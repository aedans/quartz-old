package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

data class FunctionCall(
        val expression: Expression,
        val args: List<Expression>,
        override val type: Type?
) : Expression {
    inline fun visitExpression(expressionVisitor: Visitor<Expression>): FunctionCall {
        return copy(expression = expressionVisitor(expression))
    }

    inline fun visitArgs(expressionVisitor: Visitor<Expression>): FunctionCall {
        return copy(args = args.map(expressionVisitor))
    }

    override fun toString(): String {
        return "$expression${args.joinToString(prefix = "(", postfix = ")")}"
    }
}
