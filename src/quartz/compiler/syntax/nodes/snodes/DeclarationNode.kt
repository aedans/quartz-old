package quartz.compiler.syntax.nodes.snodes

import quartz.compiler.syntax.nodes.ExpressionNode
import quartz.compiler.syntax.nodes.StatementNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class DeclarationNode(val name: String, val type: Type, val mutable: Boolean, val expression: ExpressionNode) : StatementNode {
    override fun toString(): String {
        return "${if (mutable) "var" else "val"} $name: $type = $expression"
    }

    override fun visit(builder: StringBuilder) {
        type.visit(builder)
        builder.append(" $name = ")
        expression.visit(builder)
    }
}
