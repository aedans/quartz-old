package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.visitors.util.analyzeExpression
import quartz.compiler.semantics.visitors.util.inferType
import quartz.compiler.tree.function.expression.BinaryOperator
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object BinaryOperatorAnalyzer {
    inline fun analyzeExpr1(
            crossinline expressionVisitor: Visitor<ExpressionContext>,
            context: ExpressionContext
    ): ExpressionContext {
        return context.analyzeExpression<BinaryOperator>(
                expressionVisitor,
                { it.expr1 },
                { e, _ -> e.expectedType },
                { e, expr1 -> e.copy(expr1 = expr1) }
        )
    }

    inline fun analyzeExpr2(
            crossinline expressionVisitor: Visitor<ExpressionContext>,
            context: ExpressionContext
    ): ExpressionContext {
        return context.analyzeExpression<BinaryOperator>(
                expressionVisitor,
                { it.expr2 },
                { e, _ -> e.expectedType },
                { e, expr2 -> e.copy(expr2 = expr2) }
        )
    }

    fun inferTypeFromExpr1(context: ExpressionContext): ExpressionContext {
        return context.inferType<BinaryOperator> { it.expr1.type }
    }

    fun inferTypeFromExpr2(context: ExpressionContext): ExpressionContext {
        return context.inferType<BinaryOperator> { it.expr2.type }
    }
}
