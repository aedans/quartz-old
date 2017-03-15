package quartz.compiler.syntax.nodes.snodes

import quartz.compiler.syntax.nodes.ExpressionNode
import quartz.compiler.syntax.nodes.StatementNode

/**
 * Created by Aedan Smith.
 */

class ReturnNode(val expression: ExpressionNode) : StatementNode {
    override fun toString(): String {
        return "return $expression"
    }

    override fun visit(builder: StringBuilder) {
        builder.append("return ")
        expression.visit(builder)
    }
}
