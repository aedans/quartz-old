package quartz.compiler.generator.expressions

import quartz.compiler.tree.Expression
import quartz.compiler.tree.types.VoidType

/**
 * Created by Aedan Smith.
 */

class ExpressionList(expressionList: List<Expression>): Expression, List<Expression> by expressionList {
    override val type = if (isEmpty()) VoidType else last().type

    override fun toString(): String {
        return joinToString(prefix = "{ ", postfix = " }")
    }
}
