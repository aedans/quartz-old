package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class UnaryOperator(val expression: Expression, val id: ID, override val type: Type?) : Expression {
    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return UnaryOperator(function(expression.mapExpressions(function)), id, type)
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return UnaryOperator(expression.mapTypes(function), id, function(type?.mapTypes(function)))
    }

    override fun withType(type: Type?): UnaryOperator {
        return UnaryOperator(expression, id, type)
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