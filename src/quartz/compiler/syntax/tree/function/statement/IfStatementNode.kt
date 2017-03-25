package quartz.compiler.syntax.tree.function.statement

import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.syntax.tree.function.StatementNode
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

class IfStatementNode(
        val test: ExpressionNode,
        val trueStatements: List<StatementNode>,
        val falseStatements: List<StatementNode>
) : StatementNode {
    override fun toString(): String {
        return "if ($test)"
    }

    override fun toString(i: Int): String {
        var s = ("|   " * i) + toString()
        trueStatements.forEach {
            s += '\n' + it.toString(i + 1)
        }
        if (!falseStatements.isEmpty()) {
            s += '\n' + ("|   " * i) + "else"
            falseStatements.forEach {
                s += '\n' + it.toString(i + 1)
            }
        }
        return s
    }
}
