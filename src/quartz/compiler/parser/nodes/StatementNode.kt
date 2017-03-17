package quartz.compiler.parser.nodes

import quartz.compiler.util.misc.times

/**
 * Created by Aedan Smith.
 */

interface StatementNode {
    fun toString(i: Int): String {
        return ("|   " * i) + toString()
    }
}
