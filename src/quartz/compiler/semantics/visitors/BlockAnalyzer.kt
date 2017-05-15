package quartz.compiler.semantics.visitors

import quartz.compiler.semantics.contexts.BlockContext
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.util.visitors.blockVisitor
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object BlockAnalyzer : Visitor<BlockContext> by visitor(
        ExpressionAnalyzer.blockVisitor()
)
