package quartz.compiler.tree.expression

import quartz.compiler.tree.Expression

/**
 * Created by Aedan Smith.
 */

data class ExpressionPair(val expr1: Expression, val expr2: Expression): Expression {
    override val type = expr2.type

    override fun toString(): String {
        return "$expr1, $expr2"
    }
}
