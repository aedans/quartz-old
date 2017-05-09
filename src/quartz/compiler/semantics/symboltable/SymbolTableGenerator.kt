package quartz.compiler.semantics.symboltable

import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.Lambda

/**
 * Created by Aedan Smith.
 */

fun Program.symbolTable(): GlobalSymbolTable {
    return GlobalSymbolTable(this)
}

fun SymbolTable.localSymboltable(): LocalSymbolTable {
    return LocalSymbolTable(emptyMap(), emptyMap(), this)
}

fun FunctionDeclaration.localSymbolTable(symbolTable: SymbolTable): SymbolTable {
    return LocalSymbolTable(
            argsWithNames?.map { it.first to it.second!! }?.toMap() ?: emptyMap(),
            emptyMap(),
            symbolTable
    )
}

fun Lambda.localSymbolTable(symbolTable: SymbolTable): SymbolTable {
    return LocalSymbolTable(
            argsWithNames?.map { it.first to it.second!! }?.toMap() ?: emptyMap(),
            emptyMap(),
            symbolTable
    )
}
