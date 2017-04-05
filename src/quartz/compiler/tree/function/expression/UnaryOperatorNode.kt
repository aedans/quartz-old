package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class UnaryOperatorNode(val expression: ExpressionNode, val id: ID, override val type: Type?) : ExpressionNode {
    override fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): ExpressionNode {
        return UnaryOperatorNode(function(expression.mapExpressions(function)), id, type)
    }

    override fun mapTypes(function: (Type?) -> Type?): ExpressionNode {
        return UnaryOperatorNode(expression.mapTypes(function), id, function(type?.mapTypes(function)))
    }

    override fun withType(type: Type?): UnaryOperatorNode {
        return UnaryOperatorNode(expression, id, type)
    }

    override fun toString(): String {
        return "$id($expression)"
    }

    enum class ID(val string: String) {
        INVERT("!"),
        NEGATE("-");

        override fun toString(): String {
            return string
        }
    }
}