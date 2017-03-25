package quartz.compiler.semantics

import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.function.statement.ReturnNode
import quartz.compiler.syntax.tree.misc.InlineCNode
import quartz.compiler.syntax.tree.struct.StructDeclarationNode
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.generateConstructors(symbolTable: SymbolTable): ProgramNode {
    val structConstructors =  structDeclarations.map { it.defaultConstructor() }
    structConstructors.forEach { symbolTable.getGlobalSymbolTable().addFunction(Function(it)) }
    return ProgramNode(
            fnDeclarations + structDeclarations.map { it.defaultConstructor() },
            structDeclarations,
            externFnDeclarations,
            inlineCNodes
    )
}

private fun StructDeclarationNode.defaultConstructor(): FnDeclarationNode {
    val args = members.map { it.key to it.value.type }

    var s = "(struct $type) {"
    args.dropLast(1).forEach { s += it.first + ", " }
    s += args.last().first + "}"

    return FnDeclarationNode(
            name,
            args,
            type,
            listOf(ReturnNode(InlineCNode(s).withType(this@defaultConstructor.type)))
    )
}
