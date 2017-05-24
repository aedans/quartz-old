package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.function.expression.BlockExpression

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.BlockContext.toNode(): BlockExpression {
    return when {
        expression() != null -> BlockExpression(listOf(expression().toNode()))
        else -> atomicBlock().toNode()
    }
}

fun QuartzParser.AtomicBlockContext.toNode(): BlockExpression {
    return BlockExpression(expression().map { it.toNode() })
}
