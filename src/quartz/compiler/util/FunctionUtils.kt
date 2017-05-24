package quartz.compiler.util

/**
 * Created by Aedan Smith.
 */

fun <T1, T2, R> ((T1, T2) -> R).curry(t1: T1): (T2) -> R {
    return { arg: T2 -> this(t1, arg) }
}

fun <T1, T2, T3, R> ((T1, T2, T3) -> R).curry(t1: T1): (T2, T3) -> R {
    return { arg1: T2, arg2: T3 -> this(t1, arg1, arg2) }
}
