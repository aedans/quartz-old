package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.visitors.ExpressionAnalyzer
import quartz.compiler.semantics.visitors.TypeAnalyzer
import quartz.compiler.tree.function.expression.Cast
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object CastAnalyzer : Visitor<ExpressionContext> by visitor(
        TypeAnalyzer.analyzerVisitor<Cast>({ it.type }) { e, type -> e.copy(type = type) },
        ExpressionAnalyzer.analyzerVisitor<Cast>({ it.expression }, { e, _ -> e.expectedType }) {
            e, expression -> e.copy(expression = expression) }
)
