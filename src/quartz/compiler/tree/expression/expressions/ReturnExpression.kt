package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.UnitExpression

/**
 * Created by Aedan Smith.
 */

data class ReturnExpression(val expression: Expression): UnitExpression() {
    override fun toString(): String {
        return "return $expression"
    }
}
