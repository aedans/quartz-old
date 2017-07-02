package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class FunctionCall(
        val expression: Expression,
        val args: List<Expression>,
        override val type: Type?
) : Expression {
    override fun withType(type: Type): Expression {
        return FunctionCall(expression, args, type)
    }

    override fun toString(): String {
        return "$expression${args.joinToString(prefix = "(", postfix = ")")}"
    }
}
