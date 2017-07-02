package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class LetExpression(
        val name: String,
        val value: Expression?,
        val variableType: Type?,
        val expression: Expression
): Expression {
    override val type = expression.type
    override val isLValue = false

    override fun withType(type: Type): Expression {
        return copy(expression = expression.withType(type))
    }

    override fun toString(): String {
        return "let $name: $variableType" +
                if (value != null) " = $value" else ""
    }
}
