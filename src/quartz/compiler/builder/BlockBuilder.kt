package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.function.statement.Block
import quartz.compiler.tree.function.statement.ReturnStatement

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.BlockContext.toNode(): Block {
    return Block(this.statement().map { it.toNode() })
}

fun QuartzParser.FnBlockContext.toNode(): Block {
    return if (expression() != null) {
        Block(listOf(ReturnStatement(expression().toNode())))
    } else {
        block().toNode()
    }
}
