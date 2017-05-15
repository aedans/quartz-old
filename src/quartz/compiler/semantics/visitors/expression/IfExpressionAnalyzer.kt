package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.types.IntType
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.visitors.ExpressionAnalyzer
import quartz.compiler.tree.function.expression.IfExpression
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object IfExpressionAnalyzer : Visitor<ExpressionContext> by visitor(
        ExpressionAnalyzer.analyzerVisitor<IfExpression>({ it.test }, { _, _ -> IntType }) {
            e, test -> e.copy(test = test) },
        BlockExpressionAnalyzer.blockAnalyzerVisitor<IfExpression>({ it.ifTrue }) {
            e, block -> e.copy(ifTrue = block) },
        BlockExpressionAnalyzer.blockAnalyzerVisitor<IfExpression>({ it.ifFalse }) {
            e, block -> e.copy(ifFalse = block) },
        ExpressionAnalyzer.typeAnalyzerVisitor<IfExpression>({ it.ifTrue.type }) { e, type -> e.withType(type) },
        ExpressionAnalyzer.typeAnalyzerVisitor<IfExpression>({ it.ifFalse.type }) { e, type -> e.withType(type) }
)
