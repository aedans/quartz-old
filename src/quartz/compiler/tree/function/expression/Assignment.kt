package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.LValueExpression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class Assignment(val lvalue: LValueExpression, val expression: Expression, val id: ID, override val type: Type?) : LValueExpression {
    override fun withType(type: Type?): Expression {
        return Assignment(lvalue, expression, id, type)
    }

    override fun mapExpressions(function: (Expression) -> Expression): LValueExpression {
        return Assignment(lvalue, function(expression.mapExpressions(function)), id, type)
    }

    override fun mapTypes(function: (Type?) -> Type?): LValueExpression {
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
