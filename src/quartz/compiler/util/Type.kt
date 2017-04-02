package quartz.compiler.util

/**
 * Created by Aedan Smith.
 */

interface Type {
    fun canCastTo(type: Type): Boolean

    companion object {
        fun canCast(t1: Type, t2: Type): Boolean {
            return t1.canCastTo(t2) || t2.canCastTo(t1)
        }
    }
}
