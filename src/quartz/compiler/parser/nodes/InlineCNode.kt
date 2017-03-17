package quartz.compiler.parser.nodes

import quartz.compiler.parser.nodes.ExpressionNode
import quartz.compiler.parser.nodes.StatementNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class InlineCNode(val src: String) : StatementNode, ExpressionNode {
    override var type: Type? = null

    override fun toString(): String {
        return "InlineCNode"
    }
}
