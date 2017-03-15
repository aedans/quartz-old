package quartz.compiler.syntax.nodes.enodes

import quartz.compiler.syntax.nodes.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class IdentifierNode(val name: String, override val evalType: Type) : ExpressionNode {
    override fun toString(): String {
        return "$name: $evalType"
    }

    override fun visit(builder: StringBuilder) {
        builder.append("$name")
    }
}
