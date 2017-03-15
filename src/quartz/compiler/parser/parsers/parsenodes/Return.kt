package quartz.compiler.parser.parsers.parsenodes

import quartz.compiler.parser.ParseNode

/**
 * Created by Aedan Smith.
 */

class Return : ParseNode {
    private val nodes = mutableListOf<ParseNode>()

    override fun add(node: ParseNode) {
        if (nodes.isEmpty())
            nodes.add(node)
        else
            throw RuntimeException("Could not add second node $node to $this")
    }

    override fun getNodes(): MutableList<ParseNode>? {
        return nodes
    }

    override fun toString(): String {
        return "Return"
    }
}
