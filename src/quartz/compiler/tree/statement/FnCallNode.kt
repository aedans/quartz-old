package quartz.compiler.tree.statement

import quartz.compiler.tree.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class FnCallNode(val name: String, val expressions: MutableList<ExpressionNode>) : ExpressionNode {
    override var type: Type? = null

    override fun toString(): String {
        var s = "$name("
        expressions.dropLast(1).forEach { s += it.toString() + ", " }
        if (!expressions.isEmpty()) s += expressions.last().toString()
        return "$s)"
    }
}
