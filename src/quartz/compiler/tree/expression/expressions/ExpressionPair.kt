package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

data class ExpressionPair(val expr1: Expression, val expr2: Expression): Expression {
    override val type = expr2.type

    inline fun visitExpr1(expressionVisitor: Visitor<Expression>): ExpressionPair {
        return copy(expr1 = expressionVisitor(expr1))
    }

    inline fun visitExpr2(expressionVisitor: Visitor<Expression>): ExpressionPair {
        return copy(expr2 = expressionVisitor(expr2))
    }

    override fun toString(): String {
        return "$expr1, $expr2"
    }

    override fun toString(i: Int): String {
        return "$expr1,\n${"\t" * (i + 1)}$expr2"
    }
}
