package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class NamedType(string: String) : Type(string, string) {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return this
    }

    override fun canCastTo(type: Type): Boolean {
        return type is NamedType && type.string == this.string
    }
}
