package quartz.compiler.semantics.symboltable

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.types.AliasedType
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.semantics.types.StructType
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.Lambda
import quartz.compiler.tree.function.statement.VariableDeclaration
import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

fun Program.generateSymbolTable(): SymbolTable {
    return errorScope({ "symbol table generator" }) {
        val symbolTable = SymbolTable()
        structDeclarations.forEach { symbolTable.addType(it.key, StructType(it.value)) }
        typealiasDeclarationDeclarations.forEach { symbolTable.addType(it.key, AliasedType(it.value)) }
        functionDeclarations.forEach { symbolTable.addVar(it.key, FunctionType(it.value.function)) }
        externFunctionDeclarations.forEach { symbolTable.addVar(it.key, FunctionType(it.value.function)) }
        symbolTable
    }
}

fun FunctionDeclaration.localSymbolTable(symbolTable: SymbolTable): SymbolTable {
    val localSymbolTable = function.localSymbolTable(symbolTable.localSymbolTable())
    this.argsWithNames?.forEach { localSymbolTable.addVar(it.first, it.second ?: Primitives.void) }
    return localSymbolTable
}

fun Lambda.localSymbolTable(symbolTable: SymbolTable): SymbolTable {
    val localSymbolTable = function.localSymbolTable(symbolTable.localSymbolTable())
    this.argsWithNames?.forEach { localSymbolTable.addVar(it.first, it.second ?: Primitives.void) }
    return localSymbolTable
}

@Suppress("unused")
fun Function.localSymbolTable(symbolTable: SymbolTable): SymbolTable {
    val localSymbolTable = symbolTable.localSymbolTable()
    return localSymbolTable
}

@Suppress("unused")
fun StructDeclaration.localSymbolTable(symbolTable: SymbolTable): SymbolTable {
    val localSymbolTable = symbolTable.localSymbolTable()
    return localSymbolTable
}

fun VariableDeclaration.addTo(symbolTable: SymbolTable) {
    symbolTable.addVar(name, type ?: throw QuartzException("Unknown type for $this"))
}
