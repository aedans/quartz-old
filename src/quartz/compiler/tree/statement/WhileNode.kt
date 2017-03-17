package quartz.compiler.tree.statement

import quartz.compiler.tree.ExpressionNode
import quartz.compiler.tree.StatementNode
import quartz.compiler.util.misc.times

/**
 * Created by Aedan Smith.
 */

class WhileNode(val test: ExpressionNode) : StatementNode {
    val statements = mutableListOf<StatementNode>()

    override fun toString(): String {
        return "while ($test)"
    }

    override fun toString(i: Int): String {
        var s = ("|   " * i) + toString() + "\n"
        statements.forEach {
            s += it.toString(i + 1) + "\n"
        }
        return s
    }
}
