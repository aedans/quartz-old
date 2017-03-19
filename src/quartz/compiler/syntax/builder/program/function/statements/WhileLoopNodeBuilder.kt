package quartz.compiler.syntax.builder.program.function.statements

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.program.function.toNode
import quartz.compiler.syntax.tree.program.function.statement.WhileNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.WhileLoopContext.toNode(): WhileNode {
    val whileNode = WhileNode(expression().toNode())
    block().statement()?.forEach { whileNode.statements.add(it.toNode()) }
    return whileNode
}
