package quartz.compiler.semantics.translator.function.statements

import quartz.compiler.semantics.translator.translateAll
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.syntax.tree.program.function.statement.WhileLoopNode

/**
 * Created by Aedan Smith.
 */

fun WhileLoopNode.translate(newStatements: MutableList<StatementNode>) {
    statements = statements.translateAll()
}
