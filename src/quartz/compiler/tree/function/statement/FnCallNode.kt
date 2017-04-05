package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.ExpressionNode
import quartz.compiler.tree.function.StatementNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class FnCallNode(
        val expression: ExpressionNode,
        val templates: List<Type>,
        val expressions: List<ExpressionNode>,
        override val type: Type?
) : ExpressionNode, StatementNode {
    override fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): ExpressionNode {
        return function(FnCallNode(
                function(expression.mapExpressions(function)),
                templates,
                expressions.map { it.mapExpressions(function) }.map(function),
                type
        ))
    }

    override fun mapTypes(function: (Type?) -> Type?): ExpressionNode {
        return FnCallNode(
                expression.mapTypes(function),
                templates.map { function(it.mapTypes(function))!! },
                expressions.map { it.mapTypes(function) },
                function(type?.mapTypes(function))
        )
    }

    override fun withType(type: Type?): ExpressionNode {
        return FnCallNode(expression, templates, expressions, type)
    }

    override fun toString(): String {
        return "$expression${if (templates.isNotEmpty()) "<$templates>" else ""}$expressions"
    }
}
