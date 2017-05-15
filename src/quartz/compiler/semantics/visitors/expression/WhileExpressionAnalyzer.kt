package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.types.IntType
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.visitors.ExpressionAnalyzer
import quartz.compiler.tree.function.expression.WhileExpression
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object WhileExpressionAnalyzer : Visitor<ExpressionContext> by visitor(
        ExpressionAnalyzer.analyzerVisitor<WhileExpression>({ it.test }, { _, _ -> IntType }) {
            e, test -> e.copy(test = test) },
        BlockExpressionAnalyzer.blockAnalyzerVisitor<WhileExpression>({ it.block }) {
            e, block -> e.copy(block = block) }
)
