package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.UnitExpression

/**
 * Created by Aedan Smith.
 */

data class ReturnExpression(val expression: Expression): UnitExpression() {
    override fun toString(): String {
        return "return $expression"
    }
}
