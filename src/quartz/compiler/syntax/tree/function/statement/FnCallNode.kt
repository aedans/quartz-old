package quartz.compiler.syntax.tree.function.statement

import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.syntax.tree.function.StatementNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class FnCallNode(val expression: ExpressionNode, val expressions: List<ExpressionNode>, override val type: Type?) : ExpressionNode, StatementNode {
    override fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): ExpressionNode {
        return FnCallNode(
                function(expression.mapExpressions(function)),
                expressions.map { it.mapExpressions(function) }.map(function),
                type
        )
    }

    override fun mapTypes(function: (Type?) -> Type?): ExpressionNode {
        return FnCallNode(
                expression.mapTypes(function),
                expressions.map { it.mapTypes(function) },
                function(type)
        )
    }

    override fun withType(type: Type?): ExpressionNode {
        return FnCallNode(expression, expressions, type)
    }

    override fun toString(): String {
        var s = "$expression("
        expressions.dropLast(1).forEach { s += it.toString() + ", " }
        if (!expressions.isEmpty()) s += expressions.last().toString()
        return "$s)"
    }
}
