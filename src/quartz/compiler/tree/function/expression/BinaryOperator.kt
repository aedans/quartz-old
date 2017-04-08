package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class BinaryOperator(val expr1: Expression, val expr2: Expression, val id: ID, override val type: Type?) : Expression {
    override val isLValue = false

    override fun getExpressions(): List<Expression> {
        return listOf(this) + expr1.getExpressions() + expr2.getExpressions()
    }

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
        return "$expr1 $id $expr2"
    }

    enum class ID(val string: String) {
        OR("||"),
        AND("&&"),
        EQ("=="),
        NEQ("!="),
        LT("<"),
        GT(">"),
        LEQ("<="),
        GEQ(">="),
        ADD("+"),
        SUBT("-"),
        MULT("*"),
        DIV("/"),
        MOD("%");

        override fun toString(): String {
            return string
        }
    }
}
