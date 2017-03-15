package quartz.compiler.parser.parsers.parsenodes

import quartz.compiler.parser.ParseNode

/**
 * Created by Aedan Smith.
 */

class Program : ParseNode {
    private val nodes = mutableListOf<ParseNode>()

    override fun add(node: ParseNode) {
        nodes.add(node)
    }

    override fun getNodes(): MutableList<ParseNode> {
        return nodes
    }

    override fun toString(): String {
        return "Program"
    }
}
