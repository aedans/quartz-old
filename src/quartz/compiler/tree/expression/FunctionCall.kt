package quartz.compiler.tree.expression

import quartz.compiler.tree.Expression
import quartz.compiler.tree.Type

/**
 * Created by Aedan Smith.
 */

data class FunctionCall(
        val expression: Expression,
        val args: List<Expression>,
        override val type: Type?
) : Expression {
    override fun toString(): String {
        return "$expression${if (args.isEmpty()) "()" else args.joinToString(separator = " ") { "($it)" }}"
    }
}
