package quartz.compiler.semantics.symboltable

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.Lambda
import quartz.compiler.tree.function.statement.Block
import quartz.compiler.tree.function.statement.VariableDeclaration
import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun Program.generateSymbolTable(): SymbolTable {
    return errorScope({ "symbol table generator" }) {
        val symbolTable = SymbolTable()
        structDeclarations.forEach { symbolTable.addType(it.key, it.value.type) }
        typealiasDeclarationDeclarations.forEach { symbolTable.addType(it.key, it.value.type) }
        functionDeclarations.forEach { symbolTable.addVar(it.key, FunctionType(it.value.function)) }
        externFunctionDeclarations.forEach { symbolTable.addVar(it.key, FunctionType(it.value.function)) }
        symbolTable
    }
}

fun FunctionDeclaration.localSymbolTable(symbolTable: SymbolTable): SymbolTable {
    val localSymbolTable = function.localSymbolTable(symbolTable.localSymbolTable())
    this.argsWithNames.forEach { localSymbolTable.addVar(it.first, it.second) }
    return localSymbolTable
}

fun Lambda.localSymbolTable(symbolTable: SymbolTable): SymbolTable {
    val localSymbolTable = function.localSymbolTable(symbolTable.localSymbolTable())
    this.argsWithNames.forEach { localSymbolTable.addVar(it.first, it.second) }
    return localSymbolTable
}

fun Function.localSymbolTable(symbolTable: SymbolTable): SymbolTable {
    val localSymbolTable = symbolTable.localSymbolTable()
    this.templates.forEach { localSymbolTable.addType(it.string, it) }
    return localSymbolTable
}

fun StructDeclaration.localSymbolTable(symbolTable: SymbolTable): SymbolTable {
    val localSymbolTable = symbolTable.localSymbolTable()
    this.templates.forEach { localSymbolTable.addType(it.string, it) }
    return localSymbolTable
}

fun VariableDeclaration.addTo(symbolTable: SymbolTable) {
    symbolTable.addVar(name, type ?: throw QuartzException("Unknown aliasedType for $this"))
}

fun Map.Entry<Type, Block>.localSymbolTable(symbolTable: SymbolTable, name: String): SymbolTable {
    val localSymbolTable = symbolTable.localSymbolTable()
    localSymbolTable.addVar(name, key)
    return localSymbolTable
}
