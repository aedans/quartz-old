package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.visitors.ExpressionAnalyzer
import quartz.compiler.tree.function.expression.PostfixUnaryOperator
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object PostfixUnaryOperatorAnalyzer : Visitor<ExpressionContext> by visitor(
        ExpressionAnalyzer.analyzerVisitor<PostfixUnaryOperator>({ it.expression }, { e, _ -> e.expectedType }) {
            e, expression -> e.copy(expression = expression) },
        ExpressionAnalyzer.typeAnalyzerVisitor<PostfixUnaryOperator>({ it.expression.type }) { e, type -> e.withType(type) }
)
