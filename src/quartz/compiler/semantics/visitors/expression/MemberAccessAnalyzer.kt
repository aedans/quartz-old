package quartz.compiler.semantics.visitors.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.types.StructType
import quartz.compiler.semantics.util.analyze
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.visitors.ExpressionAnalyzer
import quartz.compiler.tree.function.expression.MemberAccess
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object MemberAccessAnalyzer : Visitor<ExpressionContext> by visitor(
        ExpressionAnalyzer.analyzerVisitor<MemberAccess>({ it.expression }, { _, _ -> null }) {
            e, expression -> e.copy(expression = expression) },
        { expressionContext ->
            val (memberAccess, symbolContext) = expressionContext.asExpression<MemberAccess>()

            val (newType, newSymbolContext) =
                    (memberAccess.expression.type as? StructType
                            ?: throw QuartzException("${memberAccess.expression.type} is not a struct"))
                            .analyze(symbolContext)

            expressionContext.copy(
                    expression = memberAccess.copy(expression = memberAccess.expression.withType(newType)),
                    symbolContext = newSymbolContext
            )
        },
        { expressionContext ->
            val (memberAccess) = expressionContext.asExpression<MemberAccess>()

            val memberType = (memberAccess.expression.type as StructType)
                    .members[memberAccess.name]?.type
                    ?: throw QuartzException("Unknown member ${memberAccess.type?.string}.${memberAccess.name}")

            expressionContext.copy(
                    expression = memberAccess.copy(type = memberType)
            )
        }
)
