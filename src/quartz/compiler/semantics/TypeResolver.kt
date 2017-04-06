package quartz.compiler.semantics

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.semantics.symboltable.localSymbolTable
import quartz.compiler.semantics.types.NamedType
import quartz.compiler.semantics.types.StructType
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.tree.misc.Typealias
import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun Program.resolveTypes(): Program {
    return Program(
            functionDeclarations.mapValues { it.value.resolveTypes(symbolTable) },
            externFunctionDeclarations.mapValues { it.value.resolveTypes(symbolTable) },
            structDeclarations.mapValues { it.value.resolveTypes(symbolTable) },
            typealiasDeclarations.mapValues { it.value.resolveTypes(symbolTable) },
            inlineCNodes
    )
}

private fun FunctionDeclaration.resolveTypes(symbolTable: SymbolTable): FunctionDeclaration {
    val localSymbolTable = localSymbolTable(symbolTable)
    return this.mapTypes { it?.resolve(localSymbolTable) }
}

private fun ExternFunctionDeclaration.resolveTypes(symbolTable: SymbolTable): ExternFunctionDeclaration {
    return this.mapTypes { it?.resolve(symbolTable) }
}

private fun StructDeclaration.resolveTypes(symbolTable: SymbolTable): StructDeclaration {
    val localSymbolTable = localSymbolTable(symbolTable)
    return this.mapTypes { it?.resolve(localSymbolTable) }
}

private fun Typealias.resolveTypes(symbolTable: SymbolTable): Typealias {
    return Typealias(name, aliasedType.resolve(symbolTable), external)
}

private fun Type.resolve(symbolTable: SymbolTable): Type {
    return if (this is NamedType)
        if (templates.isEmpty()) {
            symbolTable.getType(string)
        } else {
            (symbolTable.getType(this.string) as StructType).withTemplates(templates)
        }?.mapTypes { it?.resolve(symbolTable) }
                ?: throw QuartzException("Unknown type $this")
    else this
}
