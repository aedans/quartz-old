package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class UnresolvedType(val name: String) : Type {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return this
    }

    override fun canCastTo(type: Type): Boolean {
        return type is UnresolvedType && type.name == this.name
    }

    override fun toString(): String {
        return name
    }
}
