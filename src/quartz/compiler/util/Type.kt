package quartz.compiler.util

/**
 * Created by Aedan Smith.
 */

interface Type {
    fun canCastTo(type: Type): Boolean
}
