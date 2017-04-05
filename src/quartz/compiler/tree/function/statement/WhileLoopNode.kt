package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.ExpressionNode
import quartz.compiler.tree.function.StatementNode
import quartz.compiler.util.Type
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

class WhileLoopNode(val test: ExpressionNode, val statements: List<StatementNode>) : StatementNode {
    override fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): StatementNode {
        return WhileLoopNode(function(test.mapExpressions(function)), statements.map { it.mapExpressions(function) })
    }

    override fun mapTypes(function: (Type?) -> Type?): StatementNode {
        return WhileLoopNode(test.mapTypes(function), statements.map { it.mapTypes(function) })
    }

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
