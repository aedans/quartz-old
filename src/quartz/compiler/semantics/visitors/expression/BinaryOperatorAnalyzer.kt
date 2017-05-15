package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.visitors.ExpressionAnalyzer
import quartz.compiler.tree.function.expression.BinaryOperator
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object BinaryOperatorAnalyzer : Visitor<ExpressionContext> by visitor(
        ExpressionAnalyzer.analyzerVisitor<BinaryOperator>({ it.expr1 }, { e, _ -> e.expectedType }) {
            e, expr1 -> e.copy(expr1 = expr1) },
        ExpressionAnalyzer.analyzerVisitor<BinaryOperator>({ it.expr2 }, { e, _ -> e.expectedType }) {
            e, expr2 -> e.copy(expr2 = expr2) },
        ExpressionAnalyzer.typeAnalyzerVisitor<BinaryOperator>({ it.expr1.type }) { e, type -> e.withType(type) },
        ExpressionAnalyzer.typeAnalyzerVisitor<BinaryOperator>({ it.expr2.type }) { e, type -> e.withType(type) }
)
