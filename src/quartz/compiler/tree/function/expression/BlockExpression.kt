package quartz.compiler.tree.function.expression

import quartz.compiler.semantics.types.VoidType
import quartz.compiler.tree.function.Block
import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Type

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
