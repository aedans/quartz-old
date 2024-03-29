package quartz.compiler.tree.expression

import quartz.compiler.tree.Expression
import quartz.compiler.tree.Type

/**
 * Created by Aedan Smith.
 */

data class BinaryOperation(val expr1: Expression, val expr2: Expression, val id: ID) : Expression {
    override val type = Type.greatestCommonType(expr1.type, expr2.type)

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
