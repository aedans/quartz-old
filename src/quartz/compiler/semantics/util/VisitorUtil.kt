package quartz.compiler.semantics.util

import quartz.compiler.util.Visitor

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
