package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.function.Statement
import quartz.compiler.tree.function.statement.Block

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.BlockContext.toNode(): Block {
    return Block(this.statementBlock()?.toNode() ?: listOf(statement().toNode()))
}

fun QuartzParser.StatementBlockContext.toNode(): List<Statement> {
    return this.statement().map { it.toNode() }
}
