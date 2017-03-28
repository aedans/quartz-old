package quartz.compiler.visitor.program.function

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.syntax.tree.function.StatementNode
import quartz.compiler.syntax.tree.function.statement.*
import quartz.compiler.syntax.tree.misc.InlineCNode

/**
 * Created by Aedan Smith.
 */

fun StatementNode.visit(
        inlineCVisitor: InlineCNode.() -> StatementNode = { this },
        varDeclarationVisitor: VarDeclarationNode.() -> StatementNode = { this },
        returnVisitor: ReturnNode.() -> StatementNode = { this },
        ifStatementVisitor: IfStatementNode.() -> StatementNode = { this },
        whileLoopVisitor: WhileLoopNode.() -> StatementNode = { this },
        fnCallVisitor: FnCallNode.() -> StatementNode = { this },
        varAssignmentVisitor: VarAssignmentNode.() -> StatementNode = { this }
): StatementNode {
    return when (this) {
        is InlineCNode -> inlineCVisitor(this)
        is VarDeclarationNode -> varDeclarationVisitor(this)
        is ReturnNode -> returnVisitor(this)
        is IfStatementNode -> ifStatementVisitor(this)
        is WhileLoopNode -> whileLoopVisitor(this)
        is FnCallNode -> fnCallVisitor(this)
        is VarAssignmentNode -> varAssignmentVisitor(this)
        else -> throw QuartzException("Unrecognized node $this")
    }
}
