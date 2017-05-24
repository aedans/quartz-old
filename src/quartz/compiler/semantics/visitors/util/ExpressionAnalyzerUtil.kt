package quartz.compiler.semantics.visitors.util

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

inline fun <reified T : Expression> ExpressionContext.inferType(function: (T) -> Type?): ExpressionContext {
    val (expression, symbolContext) = this.destructureAs<T>()
    val type = function(expression)
    // TODO replace with highest bounded type
    return ExpressionContext(
            expression.withType(type ?: throw QuartzException("Could not infer type for $expression")),
            symbolContext,
            type
    )
}

inline fun <reified T : Expression> ExpressionContext.analyzeExpression(
        expressionVisitor: Visitor<ExpressionContext>,
        function: (T) -> Expression?,
        expectedType: (ExpressionContext, T) -> Type?,
        clone: (T, Expression) -> T
): ExpressionContext {
    val (expression, symbolContext) = this.destructureAs<T>()
    val sExpression = function(expression)
    return sExpression?.let {
        val (newExpression, newSymbolContext) = expressionVisitor(ExpressionContext(
                it,
                symbolContext,
                expectedType(this, expression)
        ))
        copy(
                expression = clone(expression, newExpression),
                symbolContext = newSymbolContext
        )
    } ?: this
}
