package quartz.compiler.tree.expression

import quartz.compiler.tree.Expression
import quartz.compiler.tree.Type

/**
 * Created by Aedan Smith.
 */

data class NumberLiteral(val string: String, override val type: Type) : Expression {
    override fun toString(): String {
        return string
    }
}
