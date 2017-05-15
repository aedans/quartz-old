package quartz.compiler.util

/**
 * Created by Aedan Smith.
 */

abstract class Type(val descriptiveString: String) {
    abstract val string: String

    abstract fun isInstance(type: Type): Boolean

    open fun isEqualTo(type: Type): Boolean {
        return type.string == this.string
    }

    override fun toString(): String {
        return string
    }

    companion object {
        fun Type?.isInstance(type: Type?): Boolean {
            return when {
                this == null && type == null -> true
                this == null || type == null -> false
                else -> this.isInstance(type)
            }
        }
    }
}
