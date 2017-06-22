package quartz.compiler.semantics.util

import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

inline fun <T, V> Visitor<V>.visit(it: T, getter: T.() -> V, setter: T.(V) -> T): T {
    return it.setter(this(it.getter()))
}
