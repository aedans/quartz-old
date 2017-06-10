package quartz.compiler.tree.util

/**
 * Created by Aedan Smith.
 */

fun Type?.isSupertype(type: Type?): Boolean {
    return when {
        this == null && type == null -> true
        this == null || type == null -> false
        else -> this.isSupertype(type)
    }
}
