package quartz.compiler.tree.declarations

import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.VariableDeclaration
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type
import quartz.compiler.tree.util.functionString
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

data class FunctionDeclaration(
        override val name: String,
        val args: List<Pair<String, Type>>,
        val returnType: Type,
        val expression: Expression
) : VariableDeclaration {
    val argTypes get() = args.map { it.second }
    val argDeclarations get() = args.map { ArgumentDeclaration(it.first, it.second) }
    override val type = FunctionType(argTypes, returnType, false)

    inline fun visitArgs(argVisitor: Visitor<Pair<String, Type>>): FunctionDeclaration {
        return copy(args = args.map(argVisitor))
    }

    inline fun visitArgTypes(typeVisitor: Visitor<Type>): FunctionDeclaration {
        return visitArgs { it.copy(second = typeVisitor(it.second)) }
    }

    inline fun visitReturnType(typeVisitor: Visitor<Type>): FunctionDeclaration {
        return copy(returnType = typeVisitor(returnType))
    }

    inline fun visitTypes(typeVisitor: Visitor<Type>): FunctionDeclaration {
        return visitArgTypes(typeVisitor).visitReturnType(typeVisitor)
    }

    inline fun visitExpression(expressionVisitor: Visitor<Expression>): FunctionDeclaration {
        return copy(expression = expressionVisitor(expression))
    }

    override fun toString(): String {
        return "$name${functionString(argTypes, returnType, false)}\n${expression.toString(1)}"
    }

    data class ArgumentDeclaration(override val name: String, override val type: Type) : VariableDeclaration
}
