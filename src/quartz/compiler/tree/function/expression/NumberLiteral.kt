package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class NumberLiteral(val string: String, override val type: Type?) : Expression {
    override val isLValue = false

    override fun withType(type: Type?): NumberLiteral {
        return NumberLiteral(string, type)
    }

    override fun toString(): String {
        return string
    }
}
