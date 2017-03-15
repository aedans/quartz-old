package quartz.compiler.parser

import quartz.compiler.util.misc.times

/**
 * Created by Aedan Smith.
 */

interface ParseNode {
    fun add(node: ParseNode)

    fun getNodes(): List<ParseNode>?

    fun toString(depth: Int): String {
        var string = "|   " * depth
        string += this.toString() + '\n'
        getNodes()?.forEach {
            string += it.toString(depth + 1)
        }
        return string
    }
}
