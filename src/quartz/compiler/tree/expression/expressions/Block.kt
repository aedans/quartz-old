package quartz.compiler.tree.expression.expressions

import quartz.compiler.semantics.types.VoidType
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

class Block(expressionList: List<Expression>): Expression, List<Expression> by expressionList {
    override val type = if (isEmpty()) VoidType else last().type
    override val isLValue = false

    override fun withType(type: Type?): Block {
        return if (isEmpty()) this else Block(dropLast(1) + last().withType(type))
    }

    override fun toString(): String {
        return "{ ${when {
            isEmpty() -> ""
            size == 1 -> last().toString()
            else -> "... ${last()}"
        }} }"
    }

    override fun toString(i: Int): String {
        var s = ""
        forEach { s += "${it.toString(i)}\n" }
        return s
    }
}
