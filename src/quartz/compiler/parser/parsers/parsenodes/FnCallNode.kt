package quartz.compiler.parser.parsers.parsenodes

import quartz.compiler.parser.ParseNode

/**
 * Created by Aedan Smith.
 */

data class FnCallNode(val name: String) : ParseNode {
    private val nodes = mutableListOf<ParseNode>()

    override fun add(node: ParseNode) {
        nodes.add(node)
    }

    override fun getNodes(): MutableList<ParseNode> {
        return nodes
    }
}
