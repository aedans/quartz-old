package quartz.compiler.syntax.builder.program.function.statements

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.program.function.toNode
import quartz.compiler.syntax.tree.program.function.statement.IfStatementNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.IfStatementContext.toNode(): IfStatementNode {
    return IfStatementNode(
            expression().toNode(),
            trueBlock?.statement()?.map { it.toNode() } ?: listOf(),
            falseBlock?.statement()?.map { it.toNode() } ?: listOf()
    )
}
