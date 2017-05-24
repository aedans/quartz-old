package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class IfExpression(
        val condition: Expression,
        val ifTrue: BlockExpression,
        val ifFalse: BlockExpression,
        override val type: Type?
) : Expression {
    override val isLValue = false

    override fun withType(type: Type?): IfExpression {
        return IfExpression(condition, ifTrue, ifFalse, type)
    }

    override fun toString(): String {
        return "if ($condition) $ifTrue else $ifFalse"
    }
}
