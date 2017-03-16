package quartz.compiler.parser.parsers.parsenodes

import quartz.compiler.parser.ParseNode
import quartz.compiler.util.ProtoType

/**
 * Created by Aedan Smith.
 */

data class FnDeclarationNode(val name: String, val args: ArrayList<Pair<String, ProtoType>>, val rType: ProtoType) : ParseNode {
    private val nodes = mutableListOf<ParseNode>()

    override fun add(node: ParseNode) {
        nodes.add(node)
    }

    override fun getNodes(): MutableList<ParseNode> {
        return nodes
    }
}
