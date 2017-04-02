package quartz.compiler.syntax.tree.function.expression

import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class CastNode(val expression: ExpressionNode, override val type: Type?) : ExpressionNode {
    override fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): ExpressionNode {
        return CastNode(function(expression.mapExpressions(function)), type)
    }

    override fun mapTypes(function: (Type?) -> Type?): ExpressionNode {
        return CastNode(expression.mapTypes(function), function(type?.mapTypes(function)))
    }

    override fun withType(type: Type?): CastNode {
        return CastNode(expression, type)
    }

    override fun toString(): String {
        return "${if (type != null) "($type)" else ""} ($expression)"
    }
}
