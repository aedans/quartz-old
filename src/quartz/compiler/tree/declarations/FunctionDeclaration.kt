package quartz.compiler.tree.declarations

import quartz.compiler.tree.Expression
import quartz.compiler.tree.Type
import quartz.compiler.tree.types.FunctionType
import quartz.compiler.tree.util.functionString

/**
 * Created by Aedan Smith.
 */

data class FunctionDeclaration(
        override val name: String,
        override val type: FunctionType,
        val argNames: List<String>,
        val expression: Expression
) : VariableDeclaration {
    val args get() = argNames zip argTypes
    val argTypes get() = type.args
    val returnType get() = type.returnType
    val argDeclarations get() = args.map { ArgumentDeclaration(it.first, it.second) }

    override fun toString(): String {
        return "$name${functionString(argTypes, returnType, false)} = $expression"
    }

    data class ArgumentDeclaration(override val name: String, override val type: Type) : VariableDeclaration
}
