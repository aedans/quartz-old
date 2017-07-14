package quartz.compiler.tree.expression

import quartz.compiler.tree.Expression
import quartz.compiler.tree.Type

/**
 * Created by Aedan Smith.
 */

data class IfExpression(
        val condition: Expression,
        val ifTrue: Expression,
        val ifFalse: Expression
) : Expression {
    override val type = Type.greatestCommonType(ifTrue.type, ifFalse.type)

    override fun toString(): String {
        return "if $condition then $ifTrue else $ifFalse"
    }
}
