package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.UnitExpression

/**
 * Created by Aedan Smith.
 */

object EmptyExpression : UnitExpression() {
    override fun toString(): String {
        return "{}"
    }
}
