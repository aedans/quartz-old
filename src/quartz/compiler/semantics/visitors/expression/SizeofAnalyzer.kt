package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.visitors.TypeAnalyzer
import quartz.compiler.tree.function.expression.Sizeof
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object SizeofAnalyzer : Visitor<ExpressionContext> by visitor(
        TypeAnalyzer.analyzerVisitor<Sizeof>({ it.sizeType }) { e, type -> e.copy(sizeType = type) }
)
