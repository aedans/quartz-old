package quartz.compiler.generator.visitors.fndeclaration

import quartz.compiler.generator.visitors.fndeclaration.statement.visit
import quartz.compiler.syntax.tree.program.InlineCNode
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.syntax.tree.program.function.statement.*

/**
 * Created by Aedan Smith.
 */

fun StatementNode.visit(string: StringBuilder, depth: Int) {
    when (this) {
        is FnCallNode -> visit(string)
        is IfStatementNode -> visit(string, depth)
        is InlineCNode -> visit(string)
        is ReturnNode -> visit(string)
        is VarAssignmentNode -> visit(string)
        is VarDeclarationNode -> visit(string)
        is WhileLoopNode -> visit(string, depth)
        else -> throw Exception("Unrecognized node $this")
    }
}
