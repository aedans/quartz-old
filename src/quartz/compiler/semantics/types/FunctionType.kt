package quartz.compiler.semantics.types

import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class FunctionType(val function: Function) : Type(function.description()) {
    override val string = function.toString()

    override fun mapTypes(function: (Type?) -> Type?): FunctionType {
        return FunctionType(this.function.mapTypes(function))
    }

    override fun isInstance(type: Type): Boolean {
        return type is FunctionType
                && type.function.returnType == function.returnType
                && type.function.vararg == function.vararg
                && type.function.args?.size == function.args?.size
                && type.function.args?.zip(function.args ?: emptyList())?.all { it.first == it.second } ?: true
    }

    override fun toString(): String {
        return string
    }

    companion object {
        fun Function.description(): String {
            val args = args ?: emptyList()
            var string = ""
            when {
                args.isEmpty() && returnType == Primitives.void -> {
                    string += "process"
                }
                args.isEmpty() && returnType != Primitives.void -> {
                    string += returnType?.descriptiveString + "_supplier"
                }
                returnType == Primitives.void -> {
                    args.forEach { string += it?.descriptiveString + '_' }
                    string += "consumer"
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
