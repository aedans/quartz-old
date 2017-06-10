package quartz.compiler.tree.util

/**
 * Created by Aedan Smith.
 */

fun Type?.isConvertibleTo(type: Type?): Boolean {
    return when {
        this == null && type == null -> true
        this == null || type == null -> false
        else -> this.isConvertibleTo(type)
    }
}
