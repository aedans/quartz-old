package quartz.compiler.parser.nodes.statement

import quartz.compiler.parser.nodes.ExpressionNode
import quartz.compiler.parser.nodes.StatementNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class FnCallNode(val name: String, val expressions: MutableList<ExpressionNode>) : ExpressionNode, StatementNode {
    override var type: Type? = null

    override fun toString(): String {
        var s = "$name("
        expressions.dropLast(1).forEach { s += it.toString() + ", " }
        if (!expressions.isEmpty()) s += expressions.last().toString()
        return "$s)"
    }
}
