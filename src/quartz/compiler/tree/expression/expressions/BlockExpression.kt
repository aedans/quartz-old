package quartz.compiler.tree.expression.expressions

import quartz.compiler.semantics.types.VoidType
import quartz.compiler.tree.expression.Block
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

class BlockExpression(expressionList: List<Expression>): Expression, Block(expressionList) {
    override val type = if (expressionList.isEmpty()) VoidType else expressionList.last().type
    override val isLValue = false

    operator fun plus(expression: Expression): BlockExpression {
        return BlockExpression(expressionList + expression)
    }

    fun setLast(expression: Expression): BlockExpression {
        return BlockExpression(expressionList.dropLast(1) + expression)
    }

    override fun withType(type: Type?): BlockExpression {
        return if (expressionList.isEmpty())
            this
        else
            BlockExpression(expressionList.dropLast(1) + expressionList.last().withType(type))
    }

    override fun toString(i: Int): String {
        return super<Block>.toString(i)
    }
}
