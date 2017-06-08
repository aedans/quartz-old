package quartz.compiler.semantics.analyzers.expression

import quartz.compiler.semantics.util.ExpressionAnalyzer
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.BlockExpression
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

object BlockExpressionAnalyzer {
    inline fun visitExpressions(expressionVisitor: Visitor<Expression>, blockExpression: BlockExpression): BlockExpression {
        return BlockExpression(blockExpression.expressionList.map(expressionVisitor))
    }

    inline fun analyzeExpressions(expressionAnalyzer: ExpressionAnalyzer, blockExpression: BlockExpression): BlockExpression {
        return visitExpressions(expressionAnalyzer.partial(null), blockExpression)
    }
}
