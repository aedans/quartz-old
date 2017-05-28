package quartz.compiler.util

/**
 * Created by Aedan Smith.
 */

@Suppress("NOTHING_TO_INLINE")
inline fun <T1, T2, R> ((T1, T2) -> R).curried(t1: T1): (T2) -> R {
    return { arg: T2 -> this(t1, arg) }
}

@Suppress("NOTHING_TO_INLINE")
inline fun <T1, T2, T3, R> ((T1, T2, T3) -> R).curried(t1: T1): (T2, T3) -> R {
    return { arg1: T2, arg2: T3 -> this(t1, arg1, arg2) }
}

@Suppress("NOTHING_TO_INLINE")
inline fun <T1, T2, T3, T4, R> ((T1, T2, T3, T4) -> R).curried(t1: T1): (T2, T3, T4) -> R {
    return { arg1: T2, arg2: T3, arg3: T4 -> this(t1, arg1, arg2, arg3) }
}

@Suppress("NOTHING_TO_INLINE")
inline fun <T1, T2, T3, T4, T5, R> ((T1, T2, T3, T4, T5) -> R).curried(t1: T1): (T2, T3, T4, T5) -> R {
    return { arg1: T2, arg2: T3, arg3: T4, arg4: T5 -> this(t1, arg1, arg2, arg3, arg4) }
}
