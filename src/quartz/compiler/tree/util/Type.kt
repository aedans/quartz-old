package quartz.compiler.tree.util

/**
 * Created by Aedan Smith.
 */

interface Type {
    val descriptiveString: String
    val string: String

    fun isSupertype(type: Type): Boolean

    fun isEqualTo(type: Type): Boolean {
        return type.string == this.string
    }
}
