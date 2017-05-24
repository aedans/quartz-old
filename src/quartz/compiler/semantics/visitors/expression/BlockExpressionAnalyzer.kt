package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.BlockContext
import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.contexts.SymbolContext
import quartz.compiler.tree.function.expression.BlockExpression
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object BlockExpressionAnalyzer {
    inline fun analyzeExpressions(
            expressionAnalyzer: Visitor<ExpressionContext>,
            context: ExpressionContext
    ): ExpressionContext {
        val (blockExpression, symbolContext) = context.destructureAs<BlockExpression>()

        var mutableSymbolContext: SymbolContext = BlockContext(
                blockExpression,
                symbolContext,
                emptyMap()
        )

        val newExpressions = blockExpression.expressionList.map {
            val (newExpression, newScopeContext) = expressionAnalyzer(ExpressionContext(
                    it, mutableSymbolContext, null
            ))
            mutableSymbolContext = newScopeContext
            newExpression
        }

        return context.copy(
                expression = BlockExpression(newExpressions),
                symbolContext = symbolContext.copy(programContext = mutableSymbolContext.programContext)
        )
    }
}
