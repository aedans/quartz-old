package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

open class NamedType(val name: String) : Type {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return this
    }

    override fun canCastTo(type: Type): Boolean {
        return type is NamedType && type.name == this.name
    }

    override fun equals(other: Any?): Boolean {
        return other is NamedType && other.name == this.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun toString(): String {
        return name
    }
}
