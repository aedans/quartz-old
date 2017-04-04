package quartz.compiler.util

/**
 * Created by Aedan Smith.
 */

abstract class Type(val string: String) {
    abstract fun canCastTo(type: Type): Boolean

    abstract fun mapTypes(function: (Type?) -> Type?): Type

    override fun equals(other: Any?): Boolean {
        return other is Type && other.string == this.string
    }

    override fun hashCode(): Int {
        return string.hashCode()
    }

    override fun toString(): String {
        return string
    }

    companion object {
        fun canCast(t1: Type, t2: Type): Boolean {
            return t1.canCastTo(t2) || t2.canCastTo(t1)
        }
    }
}
