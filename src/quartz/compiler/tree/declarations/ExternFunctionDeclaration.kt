package quartz.compiler.tree.declarations

import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.VariableDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.tree.util.functionString

/**
 * Created by Aedan Smith.
 */

data class ExternFunctionDeclaration(
        override val name: String,
        val args: List<Type>,
        val returnType: Type,
        val vararg: Boolean
) : VariableDeclaration {
    override val type = FunctionType(args, returnType, vararg)

    override fun toString(): String {
        return "$name${functionString(args, returnType, vararg)}"
    }
}
