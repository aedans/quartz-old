package quartz.compiler.parser.nodes.statement

import quartz.compiler.parser.nodes.ExpressionNode
import quartz.compiler.parser.nodes.StatementNode
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
        var s = ("|   " * i) + toString() + "\n"
        trueStatements.forEach {
            s += it.toString(i + 1) + "\n"
        }
        s += ("|   " * i) + "else\n"
        falseStatements.forEach {
            s += it.toString(i + 1) + "\n"
        }
        return s
    }
}
