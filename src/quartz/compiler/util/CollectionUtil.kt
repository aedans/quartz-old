package quartz.compiler.util

/**
 * Created by Aedan Smith.
 */

fun <T1, T2> Iterable<T1>?.nullableZip(list: Iterable<T2>?): List<Pair<T1, T2>>? {
    return when {
        this == null || list == null -> null
        else -> this.zip(list)
    }
}

fun <T> List<T>.withLast(t: T): List<T> {
    return dropLast(1) + t
}
