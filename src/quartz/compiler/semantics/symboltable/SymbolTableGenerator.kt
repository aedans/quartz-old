package quartz.compiler.semantics.symboltable

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.Statement
import quartz.compiler.tree.function.statement.VariableDeclaration
import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun Program.generateSymbolTable(): SymbolTable {
    val symbolTable = SymbolTable()
    structDeclarations.forEach { symbolTable.addType(it.key, it.value.type) }
    typealiasDeclarationDeclarations.forEach { symbolTable.addType(it.key, it.value.type) }
    functionDeclarations.forEach { symbolTable.addVar(it.key, FunctionType(it.value.function)) }
    externFunctionDeclarations.forEach { symbolTable.addVar(it.key, FunctionType(it.value.function)) }
    return symbolTable
}

fun FunctionDeclaration.localSymbolTable(symbolTable: SymbolTable): SymbolTable {
    val localSymbolTable = symbolTable.localSymbolTable()
    this.function.templates.forEach { localSymbolTable.addType(it.string, it) }
    this.argsWithNames.forEach { localSymbolTable.addVar(it.first, it.second) }
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

fun Map.Entry<Type, List<Statement>>.localSymbolTable(symbolTable: SymbolTable, name: String): SymbolTable {
    val localSymbolTable = symbolTable.localSymbolTable()
    localSymbolTable.addVar(name, key)
    return localSymbolTable
}
