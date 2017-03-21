package quartz.compiler.syntax.tree.program.function.statement

import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

class WhileLoopNode(val test: ExpressionNode) : StatementNode {
    var statements = mutableListOf<StatementNode>()

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
