package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.expression.expressions.Block

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.BlockContext.toExpr(): Block {
    return when {
        expression() != null -> Block(listOf(expression().toExpr()))
        else -> atomicBlock().toExpr()
    }
}

fun QuartzParser.AtomicBlockContext.toExpr(): Block {
    return Block(expression().map { it.toExpr() })
}
