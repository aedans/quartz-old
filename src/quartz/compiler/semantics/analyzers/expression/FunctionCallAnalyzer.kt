package quartz.compiler.semantics.analyzers.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.util.TypedExpressionAnalyzer
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.expression.FunctionCall
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

object FunctionCallAnalyzer {
    inline fun visitExpression(expressionVisitor: Visitor<Expression>, functionCall: FunctionCall): FunctionCall {
        return functionCall.copy(expression = expressionVisitor(functionCall.expression))
    }

    inline fun visitArgs(expressionVisitor: Visitor<Expression>, functionCall: FunctionCall): FunctionCall {
        return functionCall.copy(args = functionCall.args.map(expressionVisitor))
    }

    inline fun analyzeExpression(expressionAnalyzer: TypedExpressionAnalyzer, functionCall: FunctionCall): FunctionCall {
        return visitExpression(expressionAnalyzer.partial(null), functionCall)
    }

    inline fun analyzeArguments(expressionAnalyzer: TypedExpressionAnalyzer, functionCall: FunctionCall): FunctionCall {
        val function = (functionCall.expression.type as? FunctionType)?.function
                ?: throw QuartzException("Could not call ${functionCall.expression.type}")
        function.args!!

        if (!function.vararg && function.args.size != functionCall.args.size)
            throw QuartzException("Incorrect number of arguments for $functionCall")

        val expressions = functionCall.args.zip(function.args +
                arrayOfNulls<Type>(functionCall.args.size - function.args.size))
                .map { expressionAnalyzer(it.second, it.first) }

        val newType = function.returnType

        return FunctionCall(functionCall.expression, expressions, newType)
    }
}
