package quartz.compiler.semantics

import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.function.StatementNode
import quartz.compiler.syntax.tree.misc.InlineCNode
import quartz.compiler.syntax.tree.struct.StructDeclarationNode
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.generateConstructors(): ProgramNode {
    return ProgramNode(
            fnDeclarations + structDeclarations.filter { !it.external }.map { it.defaultConstructor() },
            externFnDeclarations,
            structDeclarations,
            typealiasDeclarations,
            inlineCNodes
    )
}

private fun StructDeclarationNode.defaultConstructor(): FnDeclarationNode {
    val argsNames = members.map { it.key }
    val argTypes = members.map { it.value.type }

    val declarationNode = InlineCNode("struct $name instance")
    val assignmentNodes = members.map { InlineCNode("instance.${it.key} = ${it.value.name}") }
    val returnNode = InlineCNode("return instance").withType(type)

    val statements = mutableListOf<StatementNode>()
    statements.add(declarationNode)
    statements.addAll(assignmentNodes)
    statements.add(returnNode)

    return FnDeclarationNode(name, argsNames, Function(argTypes, emptyList(), type, false), statements)
}
