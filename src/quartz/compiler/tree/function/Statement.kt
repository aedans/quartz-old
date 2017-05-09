package quartz.compiler.tree.function

import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

interface Statement {
    fun toString(i: Int): String {
        return ("\t" * i) + toString()
    }
}
