package quartz.compiler.tree.expression

import quartz.compiler.tree.Expression
import quartz.compiler.tree.Type

/**
 * Created by Aedan Smith.
 */

data class Cast(val expression: Expression, override val type: Type) : Expression {
    override fun toString(): String {
        return "($expression) as $type"
    }
}
