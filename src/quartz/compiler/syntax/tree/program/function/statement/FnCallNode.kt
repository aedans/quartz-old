package quartz.compiler.syntax.tree.program.function.statement

import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class FnCallNode(val name: String, val expressions: List<ExpressionNode>, override val type: Type?) : ExpressionNode, StatementNode {
    override fun withType(type: Type?): ExpressionNode {
        return FnCallNode(name, expressions, type)
    }

    override fun toString(): String {
        var s = "$name("
        expressions.dropLast(1).forEach { s += it.toString() + ", " }
        if (!expressions.isEmpty()) s += expressions.last().toString()
        return "$s)"
    }
}
