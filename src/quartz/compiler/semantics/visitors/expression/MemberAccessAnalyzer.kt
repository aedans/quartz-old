package quartz.compiler.semantics.visitors.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.contexts.TypeContext
import quartz.compiler.semantics.types.StructType
import quartz.compiler.semantics.visitors.util.analyzeExpression
import quartz.compiler.tree.function.expression.MemberAccess
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object MemberAccessAnalyzer {
    inline fun analyzeExpression(
            crossinline expressionAnalyzer: Visitor<ExpressionContext>,
            context: ExpressionContext
    ): ExpressionContext {
        return context.analyzeExpression<MemberAccess>(
                expressionAnalyzer,
                { it.expression },
                { _, _ -> null },
                { e, expression -> e.copy(expression = expression) }
        )
    }

    inline fun analyzeExpressionType(
            crossinline typeAnalyzer: Visitor<TypeContext>,
            context: ExpressionContext
    ): ExpressionContext {
        val (memberAccess, symbolContext) = context.destructureAs<MemberAccess>()

        val (newType, newSymbolContext) = typeAnalyzer(TypeContext(
                (memberAccess.expression.type as? StructType
                        ?: throw QuartzException("${memberAccess.expression.type} is not a struct")),
                symbolContext
        ))

        return context.copy(
                expression = memberAccess.copy(expression = memberAccess.expression.withType(newType)),
                symbolContext = newSymbolContext
        )
    }

    fun analyzeMember(context: ExpressionContext): ExpressionContext {
        val (memberAccess) = context.destructureAs<MemberAccess>()

        val memberType = (memberAccess.expression.type as StructType)
                .members[memberAccess.name]?.type
                ?: throw QuartzException("Unknown member ${memberAccess.type}.${memberAccess.name}")

        return context.copy(
                expression = memberAccess.copy(type = memberType)
        )
    }
}
