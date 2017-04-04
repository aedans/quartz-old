package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class StructType(val name: String, val members: Map<String, Type>, val external: Boolean) : Type {
    override fun canCastTo(type: Type): Boolean {
        return type is StructType && type.name == this.name
    }

    override fun equals(other: Any?): Boolean {
        return other is StructType && other.name == this.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun mapTypes(function: (Type?) -> Type?): Type {
        return StructType(name, members.map { it.key to function(it.value.mapTypes(function))!! }.toMap(), external)
    }

    override fun toString(): String {
        return name
    }
}
