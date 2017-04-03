package quartz.compiler.semantics.symboltable

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.types.AliasedType
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.function.statement.VarDeclarationNode

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.generateSymbolTable(): SymbolTable {
    val typeTable = TypeTable()
    structDeclarations.forEach { typeTable.add(it.name, it.type) }
    typealiasDeclarations.forEach { typeTable.add(it.name, AliasedType(it.name, it.type, it.external)) }
    val symbolTable = SymbolTable(typeTable)
    fnDeclarations.forEach { symbolTable.addVar(it.name, FunctionType(it.function)) }
    externFnDeclarations.forEach { symbolTable.addVar(it.name, FunctionType(it.function)) }
    return symbolTable
}

fun FnDeclarationNode.localSymbolTable(symbolTable: SymbolTable): SymbolTable {
    val localSymbolTable = symbolTable.localSymbolTable()
    this.argsWithNames.forEach { localSymbolTable.addVar(it.first, it.second) }
    return localSymbolTable
}

fun VarDeclarationNode.addTo(symbolTable: SymbolTable) {
    symbolTable.addVar(name, type ?: throw QuartzException("Unknown type for $this"))
}
