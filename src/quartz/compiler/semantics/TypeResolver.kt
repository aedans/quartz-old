package quartz.compiler.semantics

import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.semantics.symboltable.localSymbolTable
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.types.UnresolvedType
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.tree.misc.TypealiasDeclaration
import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun Program.resolveTypes(): Program {
    return errorScope({ "type resolver" }) {
        Program(
                functionDeclarations.mapValues { it.value.resolveTypes(symbolTable) },
                externFunctionDeclarations.mapValues { it.value.resolveTypes(symbolTable) },
                structDeclarations.mapValues { it.value.resolveTypes(symbolTable) },
                typealiasDeclarationDeclarations.mapValues { it.value.resolveTypes(symbolTable) },
                inlineCNodes
        )
    }
}

private fun FunctionDeclaration.resolveTypes(symbolTable: SymbolTable): FunctionDeclaration {
    return errorScope({ "function $name" }) {
        val localSymbolTable = localSymbolTable(symbolTable)
        this.mapTypes { it?.resolve(localSymbolTable) }
    }
}

private fun ExternFunctionDeclaration.resolveTypes(symbolTable: SymbolTable): ExternFunctionDeclaration {
    return errorScope({ "extern function $name" }) {
        this.mapTypes { it?.resolve(symbolTable) }
    }
}

private fun StructDeclaration.resolveTypes(symbolTable: SymbolTable): StructDeclaration {
    return errorScope({ "struct declaration $name" }) {
        val localSymbolTable = localSymbolTable(symbolTable)
        this.mapTypes { it?.resolve(localSymbolTable) }
    }
}

private fun TypealiasDeclaration.resolveTypes(symbolTable: SymbolTable): TypealiasDeclaration {
    return errorScope({ "typealias declaration $name" }) {
        TypealiasDeclaration(name, aliasedType.resolve(symbolTable), external)
    }
}

private fun Type.resolve(symbolTable: SymbolTable): Type {
    return (when {
        this is UnresolvedType -> symbolTable.getType(string)?.mapTypes { it?.resolve(symbolTable) }
        this is FunctionType -> function.localSymbolTable(symbolTable)
                .run { this@resolve.mapTypes { it?.resolve(this) } }
        else -> this.mapTypes { it?.resolve(symbolTable) }
    }) ?: this
}
