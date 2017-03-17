package quartz.compiler.tree.statement

import quartz.compiler.tree.ExpressionNode
import quartz.compiler.tree.StatementNode

/**
 * Created by Aedan Smith.
 */

class ReturnNode(val expressionNode: ExpressionNode) : StatementNode {
    override fun toString(): String {
        return "return($expressionNode)"
    }
}
