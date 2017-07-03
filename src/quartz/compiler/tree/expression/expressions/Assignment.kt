package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.LValue
import quartz.compiler.util.Visitor
import quartz.compiler.util.lValueOrError

/**
 * Created by Aedan Smith.
 */

data class Assignment(val lvalue: LValue, val expression: Expression) : Expression {
    override val type = lvalue.type

    inline fun visitLValue(expressionVisitor: Visitor<Expression>): Assignment {
        return copy(lvalue = expressionVisitor(lvalue).lValueOrError())
    }

    inline fun visitExpression(expressionVisitor: Visitor<Expression>): Assignment {
        return copy(expression = expressionVisitor(expression))
    }

    override fun toString(): String {
        return "$lvalue = $expression"
    }
}
