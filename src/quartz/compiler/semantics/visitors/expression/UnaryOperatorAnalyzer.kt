package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.visitors.ExpressionAnalyzer
import quartz.compiler.tree.function.expression.UnaryOperator
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object UnaryOperatorAnalyzer : Visitor<ExpressionContext> by visitor(
        ExpressionAnalyzer.analyzerVisitor<UnaryOperator>({ it.expression }, { e, _ -> e.expectedType }) {
            e, expression -> e.copy(expression = expression) },
        ExpressionAnalyzer.typeAnalyzerVisitor<UnaryOperator>({ it.expression.type }) { e, type -> e.withType(type) }
)
