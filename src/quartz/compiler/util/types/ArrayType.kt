package quartz.compiler.util.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class ArrayType(val type: Type) : Type {
    override fun canCastTo(type: Type): Boolean {
        return type is ArrayType && type.type == this.type
    }

    override fun toString(): String {
        return "$type[]"
    }

    override fun equals(other: Any?): Boolean {
        return other is ArrayType && other.type == this.type
    }

    override fun hashCode(): Int{
        return type.hashCode()
    }
}
