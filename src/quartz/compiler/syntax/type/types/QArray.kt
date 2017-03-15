package quartz.compiler.syntax.type.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class QArray(val type: Type) : Type {
    override fun canCastTo(type: Type): Boolean {
        return type is QArray && type.type == this.type
    }

    override fun toString(): String {
        return "$type*"
    }

    override fun equals(other: Any?): Boolean {
        return other is QArray && other.type == this.type
    }

    override fun hashCode(): Int{
        return type.hashCode()
    }
}
