package quartz.compiler.semantics.util.analyze.expressions

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.types.UnknownType
import quartz.compiler.semantics.util.ExpressionAnalyzer
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.FunctionCall
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

inline fun FunctionCall.visitExpression(expressionVisitor: Visitor<Expression>): FunctionCall {
    return copy(expression = expressionVisitor(expression))
}

inline fun FunctionCall.visitArgs(expressionVisitor: Visitor<Expression>): FunctionCall {
    return copy(args = args.map(expressionVisitor))
}

inline fun FunctionCall.analyzeExpression(expressionAnalyzer: ExpressionAnalyzer): FunctionCall {
    return visitExpression(expressionAnalyzer.partial( UnknownType))
}

inline fun FunctionCall.analyzeArguments(expressionAnalyzer: ExpressionAnalyzer): FunctionCall {
    val function = (expression.type as? FunctionType)?.function
            ?: throw QuartzException("Could not call ${expression.type}")
    function.args!!

    if (!function.vararg && function.args.size != args.size)
        throw quartz.compiler.errors.QuartzException("Incorrect number of arguments for $this")

    val expressions = args.zip(function.args +
            arrayOfNulls<Type>(args.size - function.args.size))
            .map { expressionAnalyzer(it.second ?:  UnknownType, it.first) }

    val newType = function.returnType

    return FunctionCall(expression, expressions, newType)
}
