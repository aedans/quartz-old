package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.util.ExpressionAnalyzer
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.expression.BlockExpression
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
