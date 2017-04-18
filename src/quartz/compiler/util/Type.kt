package quartz.compiler.util

/**
 * Created by Aedan Smith.
 */

abstract class Type(val string: String, val descriptiveString: String) {
    abstract fun isInstance(type: Type): Boolean

    abstract fun mapTypes(function: (Type?) -> Type?): Type

    override fun equals(other: Any?): Boolean {
        return other is Type && other.string == this.string
    }

    open fun isEqualTo(type: Type): Boolean {
        return type.string == this.string
    }

    override fun hashCode(): Int {
        return string.hashCode()
    }

    override fun toString(): String {
        return string
    }
}
