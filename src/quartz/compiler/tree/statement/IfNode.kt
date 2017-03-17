package quartz.compiler.tree.statement

import quartz.compiler.tree.ExpressionNode
import quartz.compiler.tree.StatementNode
import quartz.compiler.util.misc.times

/**
 * Created by Aedan Smith.
 */

class IfNode(val test: ExpressionNode) : StatementNode {
    val trueStatements = mutableListOf<StatementNode>()
    val falseStatements = mutableListOf<StatementNode>()

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
