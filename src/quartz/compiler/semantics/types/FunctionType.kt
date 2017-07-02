package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Function
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class FunctionType(val function: Function) : Type {
    override fun isConvertibleTo(type: Type): Boolean {
        return type is FunctionType
                && type.function.vararg == function.vararg
                && type.function.returnType.isConvertibleTo(function.returnType)
                && type.function.args?.size == function.args?.size
                && type.function.args
                ?.zip(function.args ?: emptyList())
                ?.all { it.first.isConvertibleTo(it.second) } ?: true
    }

    override fun toString(): String {
        return function.toString()
    }
}
