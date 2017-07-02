package quartz.compiler.tree.util

/**
 * Created by Aedan Smith.
 */

interface Type {
    fun isConvertibleTo(type: Type): Boolean
}
