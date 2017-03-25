package quartz.compiler.syntax.tree.function

import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

interface StatementNode {
    fun toString(i: Int): String {
        return ("|   " * i) + toString()
    }
}
