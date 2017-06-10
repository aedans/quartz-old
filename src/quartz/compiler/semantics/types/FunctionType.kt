package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Function
import quartz.compiler.tree.util.Type
import quartz.compiler.tree.util.isSupertype

/**
 * Created by Aedan Smith.
 */

data class FunctionType(val function: Function) : Type {
    override val descriptiveString by lazy { function.description() }
    override val string by lazy { function.toString() }

    override fun isSupertype(type: Type): Boolean {
        return type is FunctionType
                && type.function.vararg == function.vararg
                && type.function.returnType.isSupertype(function.returnType)
                && type.function.args?.size == function.args?.size
                && type.function.args
                ?.zip(function.args ?: emptyList())
                ?.all { it.first.isSupertype(it.second) } ?: true
    }

    override fun toString(): String {
        return string
    }

    companion object {
        fun Function.description(): String {
            val args = args ?: emptyList()
            var string = ""
            when {
                args.isEmpty() -> {
                    string += returnType?.descriptiveString + "_supplier"
                }
                else -> {
                    args.forEach { string += it?.descriptiveString + '_' }
                    string += "to_"
                    string += returnType?.descriptiveString
                }
            }
            if (vararg)
                string += "_vararg"

            return string
        }
    }
}
