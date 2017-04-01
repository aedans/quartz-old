package quartz.compiler.visitor

import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.struct.StructDeclarationNode
import quartz.compiler.util.Type
import quartz.compiler.visitor.program.visit
import quartz.compiler.visitor.program.visitExpressions

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.visit(
        fnDeclarationVisitor: Visitor<FnDeclarationNode> = { it.visit() },
        structDeclarationVisitor: Visitor<StructDeclarationNode> = { it.visit() }
): ProgramNode {
    return ProgramNode(
            fnDeclarations.map { fnDeclarationVisitor(it) },
            structDeclarations.map { structDeclarationVisitor(it) },
            externFnDeclarations,
            inlineCNodes
    )
}

fun ProgramNode.visitExpressions(visitor: Visitor<ExpressionNode>): ProgramNode {
    return this.visit(
        { fnDeclaration -> fnDeclaration.visitExpressions(visitor) }
    )
}

fun ProgramNode.visitTypes(visitor: Visitor<Type?>): ProgramNode {
    return this.visitExpressions { it.withType(visitor(it.type)) }
}
