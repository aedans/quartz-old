package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class PointerType(val type: Type) : Type("$type*", "${type.descriptiveString}_ptr") {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return PointerType(function(type.mapTypes(function))!!)
    }

    override fun canCastTo(type: Type): Boolean {
        return type is PointerType && (type.type == type || type.type == Primitives.void)
    }

    override fun toString(): String {
        return string
    }
}
