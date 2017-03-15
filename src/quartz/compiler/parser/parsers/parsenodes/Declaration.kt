package quartz.compiler.parser.parsers.parsenodes

import quartz.compiler.parser.ParseNode
import quartz.compiler.util.ProtoType

/**
 * Created by Aedan Smith.
 */

data class Declaration(val name: String, val type: ProtoType?, val mutable: Boolean) : ParseNode {
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
}
