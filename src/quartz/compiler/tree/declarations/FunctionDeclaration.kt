package quartz.compiler.tree.declarations

import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.VariableDeclaration
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type
import quartz.compiler.tree.util.functionString

/**
 * Created by Aedan Smith.
 */

data class FunctionDeclaration(
        override val name: String,
        val args: List<Pair<String, Type>>,
        val returnType: Type,
        val expression: Expression
) : VariableDeclaration {
    val argNames get() = args.map { it.first }
    val argTypes get() = args.map { it.second }
    val argDeclarations get() = args.map { ArgumentDeclaration(it.first, it.second) }
    override val type = FunctionType(argTypes, returnType, false)

    override fun toString(): String {
        return "$name${functionString(argTypes, returnType, false)}\n${expression.toString(1)}"
    }

    data class ArgumentDeclaration(override val name: String, override val type: Type) : VariableDeclaration
}
