package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.BlockContext
import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.contexts.SymbolContext
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.visitors.ExpressionAnalyzer
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.expression.BlockExpression
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object BlockExpressionAnalyzer : Visitor<ExpressionContext> by visitor(
        { expressionContext ->
            val (blockExpression, symbolContext) = expressionContext.asExpression<BlockExpression>()

            var mutableSymbolContext: SymbolContext = BlockContext(
                    blockExpression,
                    symbolContext,
                    emptyMap()
            )

            val newExpressions = blockExpression.expressionList.map {
                val (newExpression, newScopeContext) = ExpressionAnalyzer(ExpressionContext(
                        it, mutableSymbolContext, null
                ))
                mutableSymbolContext = newScopeContext
                newExpression
            }

            expressionContext.copy(
                    expression = BlockExpression(newExpressions),
                    symbolContext = symbolContext.copy(programContext = mutableSymbolContext.programContext)
            )
        }
) {
    inline fun <reified T : Expression> blockAnalyzerVisitor(
            crossinline function: (T) -> BlockExpression,
            crossinline clone: (T, BlockExpression) -> T
    ): Visitor<ExpressionContext> {
        return { expressionContext ->
            val (expression, scopeContext) = expressionContext.asExpression<T>()
            val blockExpression = function(expression)
            val (newBlockExpression, newScopeContext, newType) = BlockExpressionAnalyzer(ExpressionContext(
                    blockExpression, scopeContext, expressionContext.expectedType))
            ExpressionContext(
                    clone(expression, newBlockExpression as? BlockExpression
                            ?: throw Exception("Expected Block, found $newBlockExpression")),
                    newScopeContext,
                    newType
            )
        }
    }
}
