package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

data class BinaryOperation(val expr1: Expression, val expr2: Expression, val id: ID) : Expression {
    override val type = Type.greatestCommonType(expr1.type, expr2.type)

    inline fun visitExpr1(expressionVisitor: Visitor<Expression>): BinaryOperation {
        return copy(expr1 = expressionVisitor(expr1))
    }

    inline fun visitExpr2(expressionVisitor: Visitor<Expression>): BinaryOperation {
        return copy(expr2 = expressionVisitor(expr2))
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
