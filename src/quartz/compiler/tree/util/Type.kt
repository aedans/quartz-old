package quartz.compiler.tree.util

/**
 * Created by Aedan Smith.
 */

interface Type {
    fun isConvertibleTo(type: Type): Boolean

    companion object {
        fun greatestCommonType(type1: Type?, type2: Type?): Type? {
            return when {
                type1 == null -> type2
                type2 == null -> type1
                type1.isConvertibleTo(type2) -> type2
                type2.isConvertibleTo(type1) -> type1
                else -> null
            }
        }
    }
}
