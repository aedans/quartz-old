package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class UnresolvedType(override val string: String) : Type(string) {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return UnresolvedType(string)
    }

    override fun isInstance(type: Type): Boolean {
        return type is UnresolvedType && type.string == this.string
    }

    override fun toString(): String {
        return string
    }
}
