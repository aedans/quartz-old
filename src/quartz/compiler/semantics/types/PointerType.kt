package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class PointerType(val type: Type) : Type("${type.descriptiveString}_ptr") {
    override val string = "$type*"

    override fun mapTypes(function: (Type?) -> Type?): Type {
        return PointerType(function(type.mapTypes(function))!!)
    }

    override fun isInstance(type: Type): Boolean {
        return type is PointerType && (this.type.isEqualTo(type.type) || type.type == Primitives.void)
    }

    override fun toString(): String {
        return string
    }
}
