package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression

/**
 * Created by Aedan Smith.
 */

data class UnaryOperation(val expression: Expression, val id: ID) : Expression {
    override val type = expression.type

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