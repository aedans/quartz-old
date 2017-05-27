package quartz.compiler.semantics.visitors.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.function.expression.FunctionCall
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object FunctionCallAnalyzer {
    inline fun analyzeExpression(expressionAnalyzer: Visitor<ExpressionContext>, context: ExpressionContext): ExpressionContext {
        val (functionCall, symbolContext) = context.destructureAs<FunctionCall>()

        val (newExpression, newSymbolContext) = expressionAnalyzer(ExpressionContext(
                functionCall.expression, symbolContext, null
        ))

        return context.copy(
                expression = functionCall.copy(expression = newExpression),
                symbolContext = newSymbolContext
        )
    }

    inline fun analyzeArguments(expressionAnalyzer: Visitor<ExpressionContext>, context: ExpressionContext): ExpressionContext {
        val (functionCall, symbolContext) = context.destructureAs<FunctionCall>()
        val function = (functionCall.expression.type as? FunctionType)?.function
                ?: throw QuartzException("Could not call ${functionCall.expression.type}")
        function.args!!

        if (!function.vararg && function.args.size != functionCall.args.size)
            throw QuartzException("Incorrect number of arguments for $functionCall")

        var mutableScopeContext = symbolContext
        val expressions = functionCall.args.zip(function.args +
                arrayOfNulls<Type>(functionCall.args.size - function.args.size))
                .map {
                    val (newExpression, newScopeContext) = expressionAnalyzer(ExpressionContext(
                            it.first,
                            mutableScopeContext,
                            it.second
                    ))
                    mutableScopeContext = newScopeContext
                    newExpression
                }

        val newType = function.returnType

        val newFunctionCall = FunctionCall(functionCall.expression, expressions, newType)

        return context.copy(
                expression = newFunctionCall,
                symbolContext = mutableScopeContext,
                expectedType = newType
        )
    }
}
