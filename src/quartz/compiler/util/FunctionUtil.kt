package quartz.compiler.util

/**
 * Created by Aedan Smith.
 */

@Suppress("NOTHING_TO_INLINE")
inline fun <T1, T2, R> ((T1, T2) -> R).partial(t1: T1): (T2) -> R {
    return { arg: T2 -> this(t1, arg) }
}

@Suppress("NOTHING_TO_INLINE")
inline fun <T1, T2, T3, R> ((T1, T2, T3) -> R).partial(t1: T1): (T2, T3) -> R {
    return { arg1: T2, arg2: T3 -> this(t1, arg1, arg2) }
}

@Suppress("NOTHING_TO_INLINE")
inline fun <T1, T2, T3, T4, R> ((T1, T2, T3, T4) -> R).partial(t1: T1): (T2, T3, T4) -> R {
    return { arg1: T2, arg2: T3, arg3: T4 -> this(t1, arg1, arg2, arg3) }
}

@Suppress("NOTHING_TO_INLINE")
inline fun <T1, T2, T3, T4, T5, R> ((T1, T2, T3, T4, T5) -> R).partial(t1: T1): (T2, T3, T4, T5) -> R {
    return { arg1: T2, arg2: T3, arg3: T4, arg4: T5 -> this(t1, arg1, arg2, arg3, arg4) }
}

@Suppress("NOTHING_TO_INLINE")
inline fun <T1, T2, R> (T1.(T2) -> R).bind(t1: T1): (T2) -> R {
    return { arg: T2 -> t1.this(arg) }
}

@Suppress("NOTHING_TO_INLINE")
inline fun <T1, T2, T3, R> (T1.(T2, T3) -> R).bind(t1: T1): (T2, T3) -> R {
    return { arg1: T2, arg2: T3 -> t1.this(arg1, arg2) }
}

@Suppress("NOTHING_TO_INLINE")
inline fun <T1, T2, T3, T4, R> (T1.(T2, T3, T4) -> R).bind(t1: T1): (T2, T3, T4) -> R {
    return { arg1: T2, arg2: T3, arg3: T4 -> t1.this(arg1, arg2, arg3) }
}

@Suppress("NOTHING_TO_INLINE")
inline fun <T1, T2, T3, T4, T5, R> (T1.(T2, T3, T4, T5) -> R).bind(t1: T1): (T2, T3, T4, T5) -> R {
    return { arg1: T2, arg2: T3, arg3: T4, arg4: T5 -> t1.this(arg1, arg2, arg3, arg4) }
}
