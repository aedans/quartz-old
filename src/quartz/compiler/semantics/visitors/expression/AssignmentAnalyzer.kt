package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.visitors.util.analyzeExpression
import quartz.compiler.semantics.visitors.util.inferType
import quartz.compiler.tree.function.expression.Assignment
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object AssignmentAnalyzer {
    inline fun analyzeLValue(
            crossinline expressionVisitor: Visitor<ExpressionContext>,
            expressionContext: ExpressionContext
    ): ExpressionContext {
        return expressionContext.analyzeExpression<Assignment>(
                expressionVisitor,
                { it.lvalue },
                { e, _ -> e.expectedType },
                { e, lvalue -> e.copy(lvalue = lvalue) }
        )
    }

    inline fun analyzeExpression(
            crossinline expressionVisitor: Visitor<ExpressionContext>,
            expressionContext: ExpressionContext
    ): ExpressionContext {
        return expressionContext.analyzeExpression<Assignment>(
                expressionVisitor,
                { it.expression },
                { e, _ -> e.expectedType },
                { e, expression -> e.copy(expression = expression) }
        )
    }

    fun inferTypeFromLValue(expressionContext: ExpressionContext): ExpressionContext {
        return expressionContext.inferType<Assignment> { it.lvalue.type }
    }

    fun inferTypeFromExpression(expressionContext: ExpressionContext): ExpressionContext {
        return expressionContext.inferType<Assignment> { it.expression.type }
    }
}
