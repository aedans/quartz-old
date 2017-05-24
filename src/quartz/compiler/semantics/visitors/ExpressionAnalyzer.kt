package quartz.compiler.semantics.visitors

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.contexts.TypeContext
import quartz.compiler.semantics.util.verifyAs
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object ExpressionAnalyzer {
    inline fun analyzeExpectedType(
            crossinline typeAnalyzer: Visitor<TypeContext>,
            context: ExpressionContext
    ): ExpressionContext {
        return context.copy(expectedType = if (context.expectedType == null) null else {
            typeAnalyzer(TypeContext(context.expectedType, context.symbolContext)).type
        })
    }

    fun verifyType(context: ExpressionContext): ExpressionContext {
        return context.copy(expression = context.expression.verifyAs(context.expectedType))
    }
}
