package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class Cast(val expression: Expression, override val type: Type) : Expression {
    override val isLValue = false

    override fun withType(type: Type?): Cast {
        return Cast(expression, type!!)
    }

    override fun toString(): String {
        return "($expression) as $type"
    }
}
