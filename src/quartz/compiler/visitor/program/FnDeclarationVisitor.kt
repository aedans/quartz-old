package quartz.compiler.visitor.program

import quartz.compiler.syntax.tree.program.function.FnDeclarationNode
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.visitor.Visitor
import quartz.compiler.visitor.program.function.visit

/**
 * Created by Aedan Smith.
 */

fun FnDeclarationNode.visit(
        statementVisitor: Visitor<StatementNode> = { it.visit() },
        statementListVisitor: Visitor<List<StatementNode>> = { it.map { statementVisitor(it) } }
): FnDeclarationNode {
    return FnDeclarationNode(
            name,
            args,
            returnType,
            statementListVisitor(statements)
    )
}
