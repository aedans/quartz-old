package quartz.compiler.semantics

import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.function.StatementNode
import quartz.compiler.syntax.tree.misc.InlineCNode
import quartz.compiler.syntax.tree.struct.StructDeclarationNode

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.generateConstructors(): ProgramNode {
    return ProgramNode(
            fnDeclarations + structDeclarations.map { it.defaultConstructor() },
            structDeclarations,
            externFnDeclarations,
            typealiasDeclarations,
            inlineCNodes
    )
}

private fun StructDeclarationNode.defaultConstructor(): FnDeclarationNode {
    val args = members.map { it.key to it.value.type }

    val declarationNode = InlineCNode("struct $name instance")
    val assignmentNodes = members.map { InlineCNode("instance.${it.key} = ${it.value.name}") }
    val returnNode = InlineCNode("return instance").withType(type)

    val statements = mutableListOf<StatementNode>()
    statements.add(declarationNode)
    statements.addAll(assignmentNodes)
    statements.add(returnNode)

    return FnDeclarationNode(name, args, type, statements)
}
