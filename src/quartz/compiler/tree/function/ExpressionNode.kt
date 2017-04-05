package quartz.compiler.tree.function

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

interface ExpressionNode : StatementNode {
    val type: Type?

    fun withType(type: Type?): ExpressionNode

    override fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): ExpressionNode

    override fun mapTypes(function: (Type?) -> Type?): ExpressionNode
}
