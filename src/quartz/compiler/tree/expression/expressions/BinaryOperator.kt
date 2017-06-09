package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class BinaryOperator(val expr1: Expression, val expr2: Expression, val id: ID, override val type: Type?) : Expression {
    override val isLValue = false

    override fun withType(type: Type?): BinaryOperator {
        return BinaryOperator(expr1, expr2, id, type)
    }

    override fun toString(): String {
        return "$expr1 $id $expr2"
    }

    enum class ID(val string: String) {
        OR("||"),
        BOR("|"),
        AND("&&"),
        BAND("&"),
        BXOR("^"),
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
        MOD("%"),
        SHL("<<"),
        SHR(">>");

        override fun toString(): String {
            return string
        }
    }
}