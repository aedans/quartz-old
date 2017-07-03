package quartz.compiler.tree.declarations

import quartz.compiler.tree.Declaration
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
) : Declaration {
    val argNames get() = args.map { it.first }
    val argTypes get() = args.map { it.second }

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
}
