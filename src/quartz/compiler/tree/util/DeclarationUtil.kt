package quartz.compiler.tree.util

import quartz.compiler.tree.Declaration

/**
 * Created by Aedan Smith.
 */

fun <T : Declaration> Iterable<T>.toMap(): Map<String, T> {
    return map { it.name to it }.toMap()
}
