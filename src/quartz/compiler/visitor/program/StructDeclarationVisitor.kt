package quartz.compiler.visitor.program

import quartz.compiler.syntax.tree.struct.StructDeclarationNode
import quartz.compiler.syntax.tree.struct.StructMemberNode
import quartz.compiler.visitor.Visitor

/**
 * Created by Aedan Smith.
 */

fun StructDeclarationNode.visit(
        structMemberVisitor: Visitor<StructMemberNode> = { it }
): StructDeclarationNode {
    return StructDeclarationNode(
            name,
            members.mapValues { structMemberVisitor(it.value) }
    )
}
