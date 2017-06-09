package quartz.compiler.tree.expression.expressions

import quartz.compiler.semantics.types.VoidType
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

class Block(val expressionList: List<Expression>): Expression {
    override val type = if (expressionList.isEmpty()) VoidType else expressionList.last().type
    override val isLValue = false

    operator fun plus(expression: Expression): Block {
        return Block(expressionList + expression)
    }

    fun setLast(expression: Expression): Block {
        return Block(expressionList.dropLast(1) + expression)
    }

    override fun withType(type: Type?): Block {
        return if (expressionList.isEmpty())
            this
        else
            Block(expressionList.dropLast(1) + expressionList.last().withType(type))
    }

    override fun toString(): String {
        return "{ ${when {
            expressionList.isEmpty() -> ""
            expressionList.size == 1 -> expressionList.last().toString()
            else -> "... ${expressionList.last()}"
        }} }"
    }

    override fun toString(i: Int): String {
        var s = ""
        expressionList.forEach { s += "${it.toString(i)}\n" }
        return s
    }
}
