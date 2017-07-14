package quartz.compiler.tree.declarations

import quartz.compiler.tree.Type
import quartz.compiler.tree.types.FunctionType
import quartz.compiler.tree.util.functionString

/**
 * Created by Aedan Smith.
 */

data class ExternFunctionDeclaration(
        override val name: String,
        override val type: FunctionType
) : VariableDeclaration {
    val args: List<Type> get() = type.args
    val returnType: Type get() = type.returnType
    val vararg: Boolean get() = type.vararg

    override fun toString(): String {
        return "$name${functionString(args, returnType, vararg)}"
    }
}
