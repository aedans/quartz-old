package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.types.IntType
import quartz.compiler.semantics.visitors.util.analyzeBlock
import quartz.compiler.semantics.visitors.util.analyzeExpression
import quartz.compiler.tree.function.expression.WhileExpression
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object WhileExpressionAnalyzer {
    inline fun analyzeCondition(
            crossinline expressionAnalyzer: Visitor<ExpressionContext>,
            context: ExpressionContext
    ): ExpressionContext {
        return context.analyzeExpression<WhileExpression>(
                expressionAnalyzer,
                { it.condition },
                { _, _ -> IntType },
                { e, condition -> e.copy(condition = condition) }
        )
    }

    inline fun analyzeBlock(
            crossinline blockAnalyzer: Visitor<ExpressionContext>,
            context: ExpressionContext
    ): ExpressionContext {
        return context.analyzeBlock<WhileExpression>(
                blockAnalyzer,
                { it.block },
                { e, block -> e.copy(block = block) }
        )
    }
}
