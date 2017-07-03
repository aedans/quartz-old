package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Function
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

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

    inline fun visitFunctionType(typeVisitor: Visitor<Type>): FunctionType {
        return copy(function = function.visitTypes(typeVisitor))
    }

    override fun toString(): String {
        return function.toString()
    }
}
