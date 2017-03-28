package quartz.compiler.util

/**
 * Created by Aedan Smith.
 */

interface Type {
    val canCastTo: (Type) -> Boolean
}
