package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class UnaryOperator(val expression: Expression, val id: ID, override val type: Type) : Expression {
    override val isLValue = false

    override fun withType(type: Type): UnaryOperator {
        return UnaryOperator(expression, id, type)
    }

    override fun toString(): String {
        return "$id$expression"
    }

    enum class ID(val string: String) {
        NOT("!"),
        BNOT("~"),
        MINUS("-");

        override fun toString(): String {
            return string
        }
    }
}