package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class AliasedType(name: String, val type: Type, val external: Boolean) : NamedType(name) {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return AliasedType(name, function(type.mapTypes(function))!!, external)
    }

    override fun canCastTo(type: Type): Boolean {
        return type == this.type || super.canCastTo(type) || type.canCastTo(type)
    }

    override fun toString(): String {
        return name
    }
}
