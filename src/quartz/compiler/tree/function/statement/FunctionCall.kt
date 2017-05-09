package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class FunctionCall(
        val expression: Expression,
        val args: List<Expression>,
        override val type: Type?
) : Expression, Statement {
    override val isLValue = false

    override fun withType(type: Type?): Expression {
        return FunctionCall(expression, args, type)
    }

    override fun toString(): String {
        return "$expression" + args.joinToString(prefix = "(", postfix = ")") { it.toString() }
    }
}
