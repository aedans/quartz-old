package quartz.compiler.visitor

import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.struct.StructDeclarationNode
import quartz.compiler.visitor.program.visit

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
            typealiasDeclarations,
            inlineCNodes
    )
}
