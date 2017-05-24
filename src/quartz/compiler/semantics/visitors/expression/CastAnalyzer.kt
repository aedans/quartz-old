package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.contexts.TypeContext
import quartz.compiler.semantics.visitors.util.analyzeExpression
import quartz.compiler.semantics.visitors.util.analyzeType
import quartz.compiler.tree.function.expression.Cast
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object CastAnalyzer {
    inline fun analyzeType(
            crossinline typeVisitor: Visitor<TypeContext>,
            context: ExpressionContext
    ): ExpressionContext {
        return context.analyzeType<Cast>(typeVisitor, { it.type }, { e, type -> e.copy(type = type) })
    }

    inline fun analyzeExpression(
            crossinline expressionVisitor: Visitor<ExpressionContext>,
            context: ExpressionContext
    ): ExpressionContext {
        return context.analyzeExpression<Cast>(
                expressionVisitor,
                { it.expression },
                { e, _ -> e.expectedType },
                { e, expression -> e.copy(expression = expression) }
        )
    }
}
