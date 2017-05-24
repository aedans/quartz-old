package quartz.compiler.semantics.visitors.util

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.expression.BlockExpression
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

inline fun <reified T : Expression> ExpressionContext.analyzeBlock(
        blockVisitor: Visitor<ExpressionContext>,
        function: (T) -> BlockExpression,
        clone: (T, BlockExpression) -> T
): ExpressionContext {
    val (expression, scopeContext) = this.destructureAs<T>()
    val blockExpression = function(expression)
    val (newBlockExpression, newScopeContext, newType) = blockVisitor(ExpressionContext(
            blockExpression, scopeContext, expectedType))
    return ExpressionContext(
            clone(expression, newBlockExpression as? BlockExpression
                    ?: throw Exception("Expected block, found $newBlockExpression")),
            newScopeContext,
            newType
    )
}
