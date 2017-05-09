package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class PrefixUnaryOperator(val expression: Expression, val id: ID, override val type: Type?) : Expression {
    override val isLValue = false

    override fun withType(type: Type?): PrefixUnaryOperator {
        return PrefixUnaryOperator(expression, id, type)
    }

    override fun toString(): String {
        return "$id$expression"
    }

    enum class ID(val string: String) {
        INCREMENT("++"),
        DECREMENT("--"),
        NOT("!"),
        BNOT("~"),
        PLUS("+"),
        MINUS("-");

        override fun toString(): String {
            return string
        }
    }
}