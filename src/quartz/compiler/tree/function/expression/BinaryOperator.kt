package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class BinaryOperator(val expr1: Expression, val expr2: Expression, val id: ID, override val type: Type?) : Expression {
    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return BinaryOperator(function(expr1.mapExpressions(function)), function(expr2.mapExpressions(function)), id, type)
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return BinaryOperator(expr1.mapTypes(function), expr2.mapTypes(function), id, function(type?.mapTypes(function)))
    }

    override fun withType(type: Type?): BinaryOperator {
        return BinaryOperator(expr1, expr2, id, type)
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
