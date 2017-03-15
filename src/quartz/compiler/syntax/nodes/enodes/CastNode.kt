package quartz.compiler.syntax.nodes.enodes

import quartz.compiler.syntax.nodes.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class CastNode(val expressionNode: ExpressionNode, override val evalType: Type) : ExpressionNode {
    override fun toString(): String {
        return "($evalType) ($expressionNode)"
    }

    override fun visit(builder: StringBuilder) {
        builder.append("($evalType) (")
        expressionNode.visit(builder)
        builder.append(")")
    }
}
