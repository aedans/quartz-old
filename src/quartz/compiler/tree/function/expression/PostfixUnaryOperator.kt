package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class PostfixUnaryOperator(val expression: Expression, val id: ID, override val type: Type?) : Expression {
    override val isLValue = false

    override fun getExpressions(): List<Expression> {
        return listOf(this) + expression.getExpressions()
    }

    override fun mapExpressions(function: (Expression) -> Expression): PostfixUnaryOperator {
        return PostfixUnaryOperator(function(expression.mapExpressions(function)), id, type)
    }

    override fun mapTypes(function: (Type?) -> Type?): PostfixUnaryOperator {
        return PostfixUnaryOperator(expression.mapTypes(function), id, function(type?.mapTypes(function)))
    }

    override fun withType(type: Type?): PostfixUnaryOperator {
        return PostfixUnaryOperator(expression, id, type)
    }

    override fun toString(): String {
        return "($expression)$id"
    }

    enum class ID(val string: String) {
        INCREMENT("++"),
        DECREMENT("--");

        override fun toString(): String {
            return string
        }
    }
}