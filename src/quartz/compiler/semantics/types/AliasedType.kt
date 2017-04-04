package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class AliasedType(string: String, val type: Type, val external: Boolean) : Type(string, string) {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return AliasedType(string, function(type.mapTypes(function))!!, external)
    }

    override fun canCastTo(type: Type): Boolean {
        return type == this.type || type is AliasedType && type.string == this.string || type.canCastTo(type)
    }

    fun getTrueType(): Type? {
        return if (type is AliasedType) type.getTrueType() else type
    }
}
