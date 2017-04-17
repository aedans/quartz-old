package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class AliasedType(string: String, val type: Type, val external: Boolean) : Type(string, string) {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return AliasedType(string, function(type.mapTypes(function))!!, external)
    }

    override fun isEqualTo(type: Type): Boolean {
        return super.isEqualTo(type) || type.isEqualTo(this.type)
    }

    override fun isInstance(type: Type): Boolean {
        return type == this.type || type is AliasedType && type.string == this.string || Type.isMutualInstance(type, this.type)
    }
}
