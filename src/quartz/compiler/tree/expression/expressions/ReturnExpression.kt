package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.UnitExpression
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

data class ReturnExpression(val expression: Expression): UnitExpression() {
    inline fun visitExpression(expressionVisitor: Visitor<Expression>): ReturnExpression {
        return copy(expression = expressionVisitor(expression))
    }

    override fun toString(): String {
        return "return $expression"
    }
}
