package quartz.compiler.tree.expression

import quartz.compiler.tree.Expression

/**
 * Created by Aedan Smith.
 */

data class ReturnExpression(val expression: Expression): UnitExpression() {
    override fun toString(): String {
        return "return $expression"
    }
}
