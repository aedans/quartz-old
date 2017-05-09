package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class IfExpression(val test: Expression, val ifTrue: Expression, val ifFalse: Expression, override val type: Type?) : Expression {
    override val isLValue = false

    override fun withType(type: Type?): IfExpression {
        return IfExpression(test, ifTrue, ifFalse, type)
    }

    override fun toString(): String {
        return "if ($test) $ifTrue else $ifFalse"
    }
}
