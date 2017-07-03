package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class NumberLiteral(val string: String, override val type: Type) : Expression {
    override fun toString(): String {
        return string
    }
}
