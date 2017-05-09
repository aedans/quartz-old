package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.function.expression.BlockExpression

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.BlockContext.toNode(): BlockExpression {
    return BlockExpression(expression().map { it.toNode() })
}

fun QuartzParser.SBlockContext.toNode(): BlockExpression {
    return BlockExpression(expression().map { it.toNode() })
}

fun QuartzParser.EBlockContext.toNode(): BlockExpression {
    return BlockExpression(expression().map { it.toNode() })
}
