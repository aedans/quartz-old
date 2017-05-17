package quartz.compiler.semantics.visitors.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.util.analyze
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.visitors.ExpressionAnalyzer
import quartz.compiler.tree.function.expression.FunctionCall
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.function.expression.MemberAccess
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object FunctionCallAnalyzer : Visitor<ExpressionContext> by visitor(
        { expressionContext ->
            val (functionCall, symbolContext) = expressionContext.asExpression<FunctionCall>()
            try {
                val (newExpression, newSymbolContext) = functionCall.expression.analyze(symbolContext, null)

                expressionContext.copy(
                        expression = functionCall.copy(expression = newExpression),
                        symbolContext = newSymbolContext
                )
            } catch (e: QuartzException) {
                if (functionCall.expression !is MemberAccess)
                    throw e

                errorScope({ "dot notation resolver" }) {
                    errorScope({ "$functionCall" }) {
                        val expression = functionCall.expression

                        val (identifier, newScopeContext) = Identifier(expression.name, null)
                                .analyze(symbolContext, functionCall.type)

                        val newFunctionCall = FunctionCall(
                                identifier,
                                listOf(expression.expression) + functionCall.args,
                                functionCall.type
                        )

                        expressionContext.copy(
                                expression = newFunctionCall,
                                symbolContext = newScopeContext
                        )
                    }
                }
            }
        },
        { expressionContext ->
            val (functionCall, symbolContext) = expressionContext.asExpression<FunctionCall>()
            val function = (functionCall.expression.type as? FunctionType)?.function
                    ?: throw QuartzException("Could not call ${functionCall.expression.type}")
            function.args!!

            if (!function.vararg && function.args.size != functionCall.args.size)
                throw QuartzException("Incorrect number of arguments for $functionCall")

            var mutableScopeContext = symbolContext
            val expressions = functionCall.args.zip(function.args +
                    arrayOfNulls<Type>(functionCall.args.size - function.args.size))
                    .map {
                        val (newExpression, newScopeContext) = ExpressionAnalyzer(ExpressionContext(
                                it.first,
                                mutableScopeContext,
                                it.second
                        ))
                        mutableScopeContext = newScopeContext
                        newExpression
                    }

            val newType = function.returnType

            val newFunctionCall = FunctionCall(functionCall.expression, expressions, newType)

            expressionContext.copy(
                    expression = newFunctionCall,
                    symbolContext = mutableScopeContext,
                    expectedType = newType
            )
        }
)
