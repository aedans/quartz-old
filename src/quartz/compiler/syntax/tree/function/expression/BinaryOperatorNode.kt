package quartz.compiler.syntax.tree.function.expression

import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class BinaryOperatorNode(val expr1: ExpressionNode, val expr2: ExpressionNode, val id: ID, override val type: Type?) : ExpressionNode {
    override fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): ExpressionNode {
        return BinaryOperatorNode(function(expr1.mapExpressions(function)), function(expr2.mapExpressions(function)), id, type)
    }

    override fun mapTypes(function: (Type?) -> Type?): ExpressionNode {
        return BinaryOperatorNode(expr1.mapTypes(function), expr2.mapTypes(function), id, function(type?.mapTypes(function)))
    }

    override fun withType(type: Type?): BinaryOperatorNode {
        return BinaryOperatorNode(expr1, expr2, id, type)
    }

    override fun toString(): String {
        return "$id($expr1, $expr2)"
    }

    enum class ID(val string: String) {
        OR("||"),
        AND("&&"),
        EQUALS("=="),
        NOT_EQUALS("!="),
        LESS_THAN("<"),
        GREATER_THAN(">"),
        LESS_THAN_OR_EQUALS("<="),
        GREATER_THAN_OR_EQUALS(">="),
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/"),
        MOD("%"),
        ARRAY_ACCESS("[]");

        override fun toString(): String {
            return string
        }
    }
}
