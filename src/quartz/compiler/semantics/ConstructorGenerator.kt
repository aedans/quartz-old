package quartz.compiler.semantics

import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.function.StatementNode
import quartz.compiler.syntax.tree.misc.InlineCNode
import quartz.compiler.syntax.tree.struct.StructDeclarationNode
import quartz.compiler.util.types.FunctionType

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.generateConstructors(symbolTable: SymbolTable): ProgramNode {
    val structConstructors = structDeclarations.map { it.defaultConstructor() }
    structConstructors.forEach { symbolTable.addVar(it.name, FunctionType(it.args.map { it.second }, it.returnType, false)) }
    return ProgramNode(
            fnDeclarations + structDeclarations.map { it.defaultConstructor() },
            structDeclarations,
            externFnDeclarations,
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

    return FnDeclarationNode(
            name,
            args,
            type,
            statements
    )
}
