package quartz.compiler.syntax.builder.program.function.statements

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.program.function.toNode
import quartz.compiler.syntax.tree.program.function.statement.WhileLoopNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.WhileLoopContext.toNode(): WhileLoopNode {
    return WhileLoopNode(expression().toNode(), block().statement()?.map { it.toNode() } ?: listOf())
}
