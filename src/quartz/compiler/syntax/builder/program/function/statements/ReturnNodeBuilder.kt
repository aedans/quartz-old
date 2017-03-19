package quartz.compiler.syntax.builder.program.function.statements

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.program.function.toNode
import quartz.compiler.syntax.tree.program.function.statement.ReturnNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ReturnStatementContext.toNode(): ReturnNode {
    return ReturnNode(expression().toNode())
}
