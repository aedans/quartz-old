package quartz.compiler.parser.parsers.parsenodes

import quartz.compiler.parser.ParseNode

/**
 * Created by Aedan Smith.
 */

class InlineC(val src: String) : ParseNode {
    override fun add(node: ParseNode) {
        throw RuntimeException("Could not add $node to $this")
    }

    override fun getNodes(): Nothing? {
        return null
    }

    override fun toString(): String {
        return "InlineC"
    }
}
