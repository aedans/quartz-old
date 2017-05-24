package quartz.compiler.semantics.visitors.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.contexts.BlockContext
import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.contexts.FunctionDeclarationContext
import quartz.compiler.tree.function.expression.ReturnExpression
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object ReturnExpressionAnalyzer {
    inline fun analyzeExpression(expressionAnalyzer: Visitor<ExpressionContext>, context: ExpressionContext): ExpressionContext {
        val (returnExpression, symbolContext) = context.destructureAs<ReturnExpression>()
        symbolContext as? BlockContext ?: throw QuartzException("Cannot return from non-function context")
        symbolContext.symbolContext as? FunctionDeclarationContext ?: throw QuartzException("Cannot return from non-function context")

        val (newExpression, newScopeContext) = expressionAnalyzer(ExpressionContext(
                returnExpression.expression,
                symbolContext,
                symbolContext.symbolContext.functionDeclaration.function.returnType
        ))

        return context.copy(
                expression = returnExpression.copy(expression = newExpression),
                symbolContext = newScopeContext
        )
    }

    fun verifyReturnType(context: ExpressionContext): ExpressionContext {
        val (returnExpression, symbolContext) = context.destructureAs<ReturnExpression>()
        symbolContext as? BlockContext ?: throw QuartzException("Cannot return from non-function context")
        symbolContext.symbolContext as? FunctionDeclarationContext ?: throw QuartzException("Cannot return from non-function context")

        // TODO replace with highest bounded type
        return if (symbolContext.symbolContext.functionDeclaration.function.returnType == null) {
            val newScopeContext = symbolContext.copy(
                    symbolContext = symbolContext.symbolContext.copy(
                            functionDeclaration = symbolContext.symbolContext.functionDeclaration.copy(
                                    function = symbolContext.symbolContext.functionDeclaration.function.copy(
                                            returnType = returnExpression.type
                                    )
                            )
                    )
            )

            context.copy(symbolContext = newScopeContext)
        } else {
            context
        }
    }
}
