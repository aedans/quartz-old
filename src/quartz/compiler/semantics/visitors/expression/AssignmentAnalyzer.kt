package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.visitors.ExpressionAnalyzer
import quartz.compiler.tree.function.expression.Assignment
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object AssignmentAnalyzer : Visitor<ExpressionContext> by visitor(
        ExpressionAnalyzer.analyzerVisitor<Assignment>({ it.lvalue }, { e, _ -> e.expectedType }) {
            e, lvalue -> e.copy(lvalue = lvalue) },
        ExpressionAnalyzer.analyzerVisitor<Assignment>({ it.expression }, { e, _ -> e.expectedType }) {
            e, expression -> e.copy(expression = expression) },
        ExpressionAnalyzer.typeAnalyzerVisitor<Assignment>({ it.lvalue.type }) { e, type -> e.withType(type) },
        ExpressionAnalyzer.typeAnalyzerVisitor<Assignment>({ it.expression.type }) { e, type -> e.withType(type) }
)
