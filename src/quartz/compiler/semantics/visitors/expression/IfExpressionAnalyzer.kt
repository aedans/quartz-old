package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.types.IntType
import quartz.compiler.semantics.visitors.util.analyzeBlock
import quartz.compiler.semantics.visitors.util.analyzeExpression
import quartz.compiler.semantics.visitors.util.inferType
import quartz.compiler.tree.function.expression.IfExpression
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object IfExpressionAnalyzer {
    inline fun analyzeCondition(
            crossinline expressionVisitor: Visitor<ExpressionContext>,
            context: ExpressionContext
    ): ExpressionContext {
        return context.analyzeExpression<IfExpression>(
                expressionVisitor,
                { it.condition },
                { _, _ -> IntType },
                { e, condition -> e.copy(condition = condition) }
        )
    }

    inline fun analyzeIfTrue(
            crossinline blockVisitor: Visitor<ExpressionContext>,
            context: ExpressionContext
    ): ExpressionContext {
        return context.analyzeBlock<IfExpression>(
                blockVisitor,
                { it.ifTrue },
                { e, block -> e.copy(ifTrue = block) }
        )
    }

    inline fun analyzeIfFalse(
            crossinline blockVisitor: Visitor<ExpressionContext>,
            context: ExpressionContext
    ): ExpressionContext {
        return context.analyzeBlock<IfExpression>(
                blockVisitor,
                { it.ifFalse },
                { e, block -> e.copy(ifFalse = block) }
        )
    }

    fun inferTypeFromIfTrue(context: ExpressionContext): ExpressionContext {
        return context.inferType<IfExpression> { it.ifTrue.type }
    }

    fun inferTypeFromIfFalse(context: ExpressionContext): ExpressionContext {
        return context.inferType<IfExpression> { it.ifFalse.type }
    }
}
