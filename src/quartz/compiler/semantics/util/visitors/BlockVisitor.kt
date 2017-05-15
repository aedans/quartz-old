package quartz.compiler.semantics.util.visitors

import quartz.compiler.semantics.contexts.BlockContext
import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.tree.function.Block
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

fun Visitor<ExpressionContext>.blockVisitor(): Visitor<BlockContext> {
    val expressionVisitor = this
    return {
        var mutableBlockContext = BlockContext(Block(emptyList()), it.symbolContext, emptyMap())

        it.block.expressionList.forEach {
            val (expression, scopeContext) = expressionVisitor(ExpressionContext(it, mutableBlockContext, null))
            mutableBlockContext = scopeContext as BlockContext
            mutableBlockContext = mutableBlockContext.copy(
                    block = Block(mutableBlockContext.block.expressionList + expression))
        }

        mutableBlockContext
    }
}
