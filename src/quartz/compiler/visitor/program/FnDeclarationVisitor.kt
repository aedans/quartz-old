package quartz.compiler.visitor.program

import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.function.StatementNode
import quartz.compiler.visitor.Visitor
import quartz.compiler.visitor.program.function.visit
import quartz.compiler.visitor.program.function.visitExpressions

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

fun FnDeclarationNode.visitExpressions(visitor: Visitor<ExpressionNode>): FnDeclarationNode {
    return this.visit(
            { statement -> statement.visitExpressions(visitor) }
    )
}
