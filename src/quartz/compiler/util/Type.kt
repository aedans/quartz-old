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
}
