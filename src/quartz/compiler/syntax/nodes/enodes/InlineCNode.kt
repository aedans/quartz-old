package quartz.compiler.syntax.nodes.enodes

import quartz.compiler.syntax.nodes.ExpressionNode
import quartz.compiler.syntax.nodes.StatementNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class InlineCNode(val src: String, override val evalType: Type): ExpressionNode, StatementNode {
    override fun toString(): String {
        return "%$src%"
    }

    override fun visit(builder: StringBuilder) {
        builder.append(src)
    }
}
