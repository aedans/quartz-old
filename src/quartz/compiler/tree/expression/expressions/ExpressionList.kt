package quartz.compiler.tree.expression.expressions

import quartz.compiler.semantics.types.VoidType
import quartz.compiler.tree.expression.Expression

/**
 * Created by Aedan Smith.
 */

class ExpressionList(expressionList: List<Expression>): Expression, List<Expression> by expressionList {
    override val type = if (isEmpty()) VoidType else last().type

    override fun toString(): String {
        return "{ ${when (size) {
            0 -> ""
            1 -> last().toString()
            else -> "... ${last()}"
        }} }"
    }

    override fun toString(i: Int): String {
        var s = ""
        forEach { s += "${it.toString(i)}\n" }
        return s
    }
}
