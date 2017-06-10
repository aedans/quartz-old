package quartz.compiler.tree.util

/**
 * Created by Aedan Smith.
 */

interface Type {
    val descriptiveString: String
    val string: String

    fun isConvertibleTo(type: Type): Boolean
}
