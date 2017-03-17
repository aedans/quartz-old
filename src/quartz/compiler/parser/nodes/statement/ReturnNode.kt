package quartz.compiler.parser.nodes.statement

import quartz.compiler.parser.nodes.ExpressionNode
import quartz.compiler.parser.nodes.StatementNode

/**
 * Created by Aedan Smith.
 */

class ReturnNode(val expressionNode: ExpressionNode) : StatementNode {
    override fun toString(): String {
        return "return($expressionNode)"
    }
}
