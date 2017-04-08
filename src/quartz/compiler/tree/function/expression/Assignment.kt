package quartz.compiler.tree.function.expression

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class Assignment(val lvalue: Expression, val expression: Expression, val id: ID, override val type: Type?) : Expression {
    override val isLValue = false

    init {
        if (!lvalue.isLValue)
            throw QuartzException("$lvalue is not a valid lvalue")
    }

    override fun getExpressions(): List<Expression> {
        return listOf(this) + lvalue.getExpressions() + expression.getExpressions()
    }

    override fun withType(type: Type?): Expression {
        return Assignment(lvalue, expression, id, type)
    }

    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return Assignment(lvalue, function(expression.mapExpressions(function)), id, type)
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return Assignment(lvalue, expression.mapTypes(function), id, function(type?.mapTypes(function)))
    }

    override fun toString(): String {
        return "$lvalue = $expression"
    }

    enum class ID(val string: String) {
        EQ("="),
        PLUS_EQ("+="),
        MINUS_EQ("-="),
        TIMES_EQ("*="),
        DIV_EQ("/="),
        MOD_EQ("%=");

        override fun toString(): String {
            return string
        }
    }
}
