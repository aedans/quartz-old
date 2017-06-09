package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.expression.expressions.Block

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.BlockContext.toNode(): Block {
    return when {
        expression() != null -> Block(listOf(expression().toNode()))
        else -> atomicBlock().toNode()
    }
}

fun QuartzParser.AtomicBlockContext.toNode(): Block {
    return Block(expression().map { it.toNode() })
}
