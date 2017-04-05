package quartz.compiler.semantics.symboltable

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.ProgramNode
import quartz.compiler.tree.function.FnDeclarationNode
import quartz.compiler.tree.function.statement.VarDeclarationNode
import quartz.compiler.tree.struct.StructDeclarationNode

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.generateSymbolTable(): SymbolTable {
    val symbolTable = SymbolTable()
    structDeclarations.forEach { symbolTable.addType(it.name, it.type) }
    typealiasDeclarations.forEach { symbolTable.addType(it.name, it.type) }
    fnDeclarations.forEach { symbolTable.addVar(it.name, FunctionType(it.function)) }
    externFnDeclarations.forEach { symbolTable.addVar(it.name, FunctionType(it.function)) }
    return symbolTable
}

fun FnDeclarationNode.localSymbolTable(symbolTable: SymbolTable): SymbolTable {
    val localSymbolTable = symbolTable.localSymbolTable()
    this.function.templates.forEach { localSymbolTable.addType(it.string, it) }
    this.argsWithNames.forEach { localSymbolTable.addVar(it.first, it.second) }
    return localSymbolTable
}

fun StructDeclarationNode.localSymbolTable(symbolTable: SymbolTable): SymbolTable {
    val localSymbolTable = symbolTable.localSymbolTable()
    this.templates.forEach { localSymbolTable.addType(it.string, it) }
    return localSymbolTable
}

fun VarDeclarationNode.addTo(symbolTable: SymbolTable) {
    symbolTable.addVar(name, type ?: throw QuartzException("Unknown aliasedType for $this"))
}
