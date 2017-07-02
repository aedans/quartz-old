package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

data class ExpressionPair(val expr1: Expression, val expr2: Expression): Expression {
    override val type = expr2.type
    override val isLValue get() = false

    override fun withType(type: Type): Expression {
        return copy(expr2 = expr2.withType(type))
    }

    override fun toString(): String {
        return "$expr1, $expr2"
    }

    override fun toString(i: Int): String {
        return "$expr1, ${"\t" * i}$expr2"
    }
}
