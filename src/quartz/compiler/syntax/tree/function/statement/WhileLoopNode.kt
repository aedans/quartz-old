package quartz.compiler.syntax.tree.function.statement

import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.syntax.tree.function.StatementNode
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

class WhileLoopNode(val test: ExpressionNode, val statements: List<StatementNode>) : StatementNode {
    override fun toString(): String {
        return "while ($test)"
    }

    override fun toString(i: Int): String {
        var s = ("|   " * i) + toString()
        statements.forEach {
            s += '\n' + it.toString(i + 1)
        }
        return s
    }
}
