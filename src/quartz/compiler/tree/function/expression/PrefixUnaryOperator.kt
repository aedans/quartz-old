package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class PrefixUnaryOperator(val expression: Expression, val id: ID, override val type: Type?) : Expression {
    override val isLValue = false

    override fun getExpressions(): List<Expression> {
        return listOf(this) + expression.getExpressions()
    }

    override fun mapExpressions(function: (Expression) -> Expression): PrefixUnaryOperator {
        return PrefixUnaryOperator(function(expression.mapExpressions(function)), id, type)
    }

    override fun mapTypes(function: (Type?) -> Type?): PrefixUnaryOperator {
        return PrefixUnaryOperator(expression.mapTypes(function), id, function(type?.mapTypes(function)))
    }

    override fun withType(type: Type?): PrefixUnaryOperator {
        return PrefixUnaryOperator(expression, id, type)
    }

    override fun toString(): String {
        return "$id($expression)"
    }

    enum class ID(val string: String) {
        INCREMENT("++"),
        DECREMENT("--"),
        INVERT("!"),
        NEGATE("-");

        override fun toString(): String {
            return string
        }
    }
}