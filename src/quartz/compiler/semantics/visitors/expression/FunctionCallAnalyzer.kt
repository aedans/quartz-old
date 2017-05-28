package quartz.compiler.semantics.visitors.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.util.ExpressionAnalyzer
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.expression.FunctionCall
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.curried

/**
 * Created by Aedan Smith.
 */

object FunctionCallAnalyzer {
    inline fun visitExpression(expressionVisitor: Visitor<Expression>, functionCall: FunctionCall): FunctionCall {
        return functionCall.copy(expression = expressionVisitor(functionCall.expression))
    }

    inline fun analyzeExpression(expressionAnalyzer: ExpressionAnalyzer, functionCall: FunctionCall): FunctionCall {
        return visitExpression(expressionAnalyzer.curried(null), functionCall)
    }

    inline fun analyzeArguments(expressionAnalyzer: ExpressionAnalyzer, functionCall: FunctionCall): FunctionCall {
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
