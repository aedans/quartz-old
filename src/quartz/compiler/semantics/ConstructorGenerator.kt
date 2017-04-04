package quartz.compiler.semantics

import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.function.StatementNode
import quartz.compiler.syntax.tree.function.expression.IdentifierNode
import quartz.compiler.syntax.tree.function.statement.ReturnNode
import quartz.compiler.syntax.tree.function.statement.VarDeclarationNode
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
    val newType = type.withTemplates(templates)

    val declarationNode = VarDeclarationNode("instance", null, newType, true)
    val assignmentNodes = members.map { InlineCNode("instance.${it.key} = ${it.value.name}") }
    val returnNode = ReturnNode(IdentifierNode("instance", newType))

    val statements = mutableListOf<StatementNode>()
    statements.add(declarationNode)
    statements.addAll(assignmentNodes)
    statements.add(returnNode)

    return FnDeclarationNode(name, argsNames, Function(argTypes, templates, newType, false), statements)
}
