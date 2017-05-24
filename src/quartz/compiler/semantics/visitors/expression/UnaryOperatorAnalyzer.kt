package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.visitors.util.analyzeExpression
import quartz.compiler.semantics.visitors.util.inferType
import quartz.compiler.tree.function.expression.UnaryOperator
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object UnaryOperatorAnalyzer {
    inline fun analyzeExpression(
            crossinline expressionAnalyzer: Visitor<ExpressionContext>,
            context: ExpressionContext
    ): ExpressionContext {
        return context.analyzeExpression<UnaryOperator>(
                expressionAnalyzer,
                { it.expression },
                { e, _ -> e.expectedType },
                { e, expression -> e.copy(expression = expression) }
        )
    }

    fun inferTypeFromExpression(context: ExpressionContext): ExpressionContext {
        return context.inferType<UnaryOperator> { it.expression.type }
    }
}
