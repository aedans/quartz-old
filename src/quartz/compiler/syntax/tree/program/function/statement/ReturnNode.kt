package quartz.compiler.syntax.tree.program.function.statement

import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.StatementNode

/**
 * Created by Aedan Smith.
 */

class ReturnNode(var expressionNode: ExpressionNode) : StatementNode {
    override fun toString(): String {
        return "return($expressionNode)"
    }
}
