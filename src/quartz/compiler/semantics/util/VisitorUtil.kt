package quartz.compiler.semantics.util

import quartz.compiler.util.Context
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

fun <T : Any, C : Context<T>> contextVisitor(vararg visitorMap: Pair<KClass<*>, Visitor<C>>): Visitor<C> {
    return { tContext: C ->
        val kclass = tContext.t::class
        (visitorMap.firstOrNull { kclass.isSubclassOf(it.first) }
                ?: throw Exception("Expected ${kclass.simpleName}, found ${tContext.t}"))
                .second(tContext)
    }
}

fun <T> identityVisitor(): Visitor<T> {
    return { it }
}
