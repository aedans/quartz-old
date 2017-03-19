package quartz.compiler.syntax.builder.program.function.statements

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.program.function.toNode
import quartz.compiler.syntax.tree.program.function.statement.IfStatementNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.IfStatementContext.toNode(): IfStatementNode {
    val ifStatement = IfStatementNode(expression().toNode())
    trueBlock?.statement()?.forEach { ifStatement.trueStatements.add(it.toNode()) }
    falseBlock?.statement()?.forEach { ifStatement.falseStatements.add(it.toNode()) }
    return ifStatement
}
