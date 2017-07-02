package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class IfExpression(
        val condition: Expression,
        val ifTrue: Expression,
        val ifFalse: Expression?,
        override val type: Type?
) : Expression {
    override fun withType(type: Type): IfExpression {
        return IfExpression(condition, ifTrue, ifFalse, type)
    }

    override fun toString(): String {
        return "if $condition then $ifTrue else $ifFalse"
    }
}
