package quartz.compiler.semantics.visitors.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.contexts.BlockContext
import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.contexts.FunctionDeclarationContext
import quartz.compiler.semantics.util.analyze
import quartz.compiler.semantics.util.visitor
import quartz.compiler.tree.function.expression.ReturnExpression
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object ReturnAnalyzer : Visitor<ExpressionContext> by visitor(
        { expressionContext ->
            val (returnExpression, symbolContext) = expressionContext.asExpression<ReturnExpression>()
            symbolContext as? BlockContext ?: throw QuartzException("Cannot return from non-function context")
            symbolContext.symbolContext as? FunctionDeclarationContext ?: throw QuartzException("Cannot return from non-function context")

            val (newExpression, newScopeContext) = returnExpression.expression.analyze(
                    symbolContext,
                    symbolContext.symbolContext.functionDeclaration.function.returnType
            )

            expressionContext.copy(
                    expression = returnExpression.copy(expression = newExpression),
                    symbolContext = newScopeContext
            )
        },
        { expressionContext ->
            val (returnExpression, symbolContext) = expressionContext.asExpression<ReturnExpression>()
            symbolContext as? BlockContext ?: throw QuartzException("Cannot return from non-function context")
            symbolContext.symbolContext as? FunctionDeclarationContext ?: throw QuartzException("Cannot return from non-function context")

            // TODO replace with highest bounded type
            if (symbolContext.symbolContext.functionDeclaration.function.returnType == null) {
                val newScopeContext = symbolContext.copy(
                        symbolContext = symbolContext.symbolContext.copy(
                                functionDeclaration = symbolContext.symbolContext.functionDeclaration.copy(
                                        function = symbolContext.symbolContext.functionDeclaration.function.copy(
                                                returnType = returnExpression.type
                                        )
                                )
                        )
                )

                expressionContext.copy(symbolContext = newScopeContext)
            } else {
                expressionContext
            }
        }
)
