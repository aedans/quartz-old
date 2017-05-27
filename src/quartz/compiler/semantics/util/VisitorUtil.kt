package quartz.compiler.semantics.util

import quartz.compiler.util.Visitor
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

/**
 * Created by Aedan Smith.
 */

fun <T> visitor(vararg visitors: Visitor<T>): Visitor<T> {
    return {
        var mutableIt = it
        visitors.forEach { mutableIt = it(mutableIt) }
        mutableIt
    }
}

inline fun <reified T : Any, C> contextVisitor(
        crossinline function: (C) -> T,
        vararg visitorMap: Pair<KClass<*>, Visitor<C>>
): Visitor<C> {
    return { tContext: C ->
        val kclass = function(tContext)::class
        (visitorMap.firstOrNull { kclass.isSubclassOf(it.first) }
                ?: throw Exception("Expected ${T::class.simpleName}, found ${function(tContext)}"))
                .second(tContext)
    }
}

fun <T> identityVisitor(): Visitor<T> {
    return { it }
}
