package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class AliasedType(val name: String, val type: Type, val external: Boolean) : Type {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return AliasedType(name, function(type.mapTypes(function))!!, external)
    }

    override fun canCastTo(type: Type): Boolean {
        return type == this.type || type is AliasedType && type.name == this.name || type.canCastTo(type)
    }

    fun getTrueType(): Type? {
        return if (type is AliasedType) type.getTrueType() else type
    }

    override fun toString(): String {
        return name
    }
}
