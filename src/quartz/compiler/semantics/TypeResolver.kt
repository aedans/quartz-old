package quartz.compiler.semantics

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.semantics.symboltable.localSymbolTable
import quartz.compiler.semantics.types.NamedType
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.misc.ExternFnDeclarationNode
import quartz.compiler.syntax.tree.misc.TypealiasNode
import quartz.compiler.syntax.tree.struct.StructDeclarationNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.resolveTypes(): ProgramNode {
    return ProgramNode(
            fnDeclarations.map { it.resolveTypes(symbolTable) },
            externFnDeclarations.map { it.resolveTypes(symbolTable) },
            structDeclarations.map { it.resolveTypes(symbolTable) },
            typealiasDeclarations.map { it.resolveTypes(symbolTable) },
            inlineCNodes
    )
}

private fun FnDeclarationNode.resolveTypes(symbolTable: SymbolTable): FnDeclarationNode {
    val localSymbolTable = localSymbolTable(symbolTable)
    return this.mapTypes { it?.resolve(localSymbolTable) }
}

private fun ExternFnDeclarationNode.resolveTypes(symbolTable: SymbolTable): ExternFnDeclarationNode {
    return this.mapTypes { it?.resolve(symbolTable) }
}

private fun StructDeclarationNode.resolveTypes(symbolTable: SymbolTable): StructDeclarationNode {
    val localSymbolTable = localSymbolTable(symbolTable)
    return this.mapTypes { it?.resolve(localSymbolTable) }
}

private fun TypealiasNode.resolveTypes(symbolTable: SymbolTable): TypealiasNode {
    return TypealiasNode(name, aliasedType.resolve(symbolTable), external)
}

private fun Type.resolve(symbolTable: SymbolTable): Type {
    return if (this is NamedType)
        symbolTable.getType(this.string)?.withTemplates(templates)?.mapTypes { it?.resolve(symbolTable) }
                ?: throw QuartzException("Unknown type $this")
    else this
}
