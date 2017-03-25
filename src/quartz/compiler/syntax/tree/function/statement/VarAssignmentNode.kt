package quartz.compiler.syntax.tree.function.statement

import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.syntax.tree.function.StatementNode

/**
 * Created by Aedan Smith.
 */

class VarAssignmentNode(val name: String, val expression: ExpressionNode) : StatementNode {
    override fun toString(): String {
        return "$name = $expression"
    }
}
