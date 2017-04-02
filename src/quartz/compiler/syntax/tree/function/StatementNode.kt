package quartz.compiler.syntax.tree.function

import quartz.compiler.util.Type
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

interface StatementNode {
    fun toString(i: Int): String {
        return ("|   " * i) + toString()
    }

    fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): StatementNode

    fun mapTypes(function: (Type?) -> Type?): StatementNode
}
