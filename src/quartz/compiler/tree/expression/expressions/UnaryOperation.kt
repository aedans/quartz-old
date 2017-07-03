package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

data class UnaryOperation(val expression: Expression, val id: ID) : Expression {
    override val type = expression.type

    inline fun visitExpression(expressionVisitor: Visitor<Expression>): UnaryOperation {
        return copy(expression = expressionVisitor(expression))
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