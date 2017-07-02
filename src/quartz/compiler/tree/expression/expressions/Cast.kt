package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class Cast(val expression: Expression, override val type: Type) : Expression {
    override fun withType(type: Type): Cast {
        return Cast(expression, type)
    }

    override fun toString(): String {
        return "($expression) as $type"
    }
}
