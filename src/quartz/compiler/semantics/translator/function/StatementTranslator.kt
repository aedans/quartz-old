package quartz.compiler.semantics.translator.function

import quartz.compiler.semantics.translator.function.statements.translate
import quartz.compiler.syntax.tree.program.InlineCNode
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.syntax.tree.program.function.statement.*

/**
 * Created by Aedan Smith.
 */

fun StatementNode.translate(newStatements: MutableList<StatementNode>) {
    when (this) {
        is InlineCNode -> { }
        is FnCallNode -> translate(newStatements)
        is IfStatementNode -> translate(newStatements)
        is ReturnNode -> translate(newStatements)
        is VarDeclarationNode -> translate(newStatements)
        is WhileLoopNode -> translate(newStatements)
        is VarAssignmentNode -> translate(newStatements)
        else -> throw Exception("Unrecognized statement $this")
    }
    newStatements.add(this)
}
