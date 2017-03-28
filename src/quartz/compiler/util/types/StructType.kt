package quartz.compiler.util.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class StructType(val name: String, val members: Map<String, Type>) : Type {
    override val canCastTo: (Type) -> Boolean = { it is StructType && it.name == this.name }

    override fun equals(other: Any?): Boolean {
        return other is StructType && other.name == this.name
    }

    override fun toString(): String {
        return name
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + members.hashCode()
        result = 31 * result + canCastTo.hashCode()
        return result
    }
}
