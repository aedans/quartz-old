package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.ExpressionNode
import quartz.compiler.tree.function.StatementNode
import quartz.compiler.util.Type
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

class IfStatementNode(
        val test: ExpressionNode,
        val trueStatements: List<StatementNode>,
        val falseStatements: List<StatementNode>
) : StatementNode {
    override fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): StatementNode {
        return IfStatementNode(
                function(test.mapExpressions(function)),
                trueStatements.map { it.mapExpressions(function) },
                falseStatements.map { it.mapExpressions(function) }
        )
    }

    override fun mapTypes(function: (Type?) -> Type?): StatementNode {
        return IfStatementNode(
                test.mapTypes(function),
                trueStatements.map { it.mapTypes(function) },
                falseStatements.map { it.mapTypes(function) }
        )
    }

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
