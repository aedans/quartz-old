package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.util.ExpressionAnalyzer
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.expression.ReturnExpression
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

object ReturnExpressionAnalyzer {
    inline fun visitExpression(expressionVisitor: Visitor<Expression>, returnExpression: ReturnExpression): ReturnExpression {
        return returnExpression.copy(expression = expressionVisitor(returnExpression.expression))
    }

    inline fun analyzeExpression(expressionAnalyzer: ExpressionAnalyzer, returnExpression: ReturnExpression): ReturnExpression {
        return visitExpression(expressionAnalyzer.partial(null), returnExpression)
    }
}
