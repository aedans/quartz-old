package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.visitors.ExpressionAnalyzer
import quartz.compiler.tree.function.expression.PrefixUnaryOperator
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object PrefixUnaryOperatorAnalyzer : Visitor<ExpressionContext> by visitor(
        ExpressionAnalyzer.analyzerVisitor<PrefixUnaryOperator>({ it.expression }, { e, _ -> e.expectedType }) {
            e, expression -> e.copy(expression = expression) },
        ExpressionAnalyzer.typeAnalyzerVisitor<PrefixUnaryOperator>({ it.expression.type }) { e, type -> e.withType(type) }
)
