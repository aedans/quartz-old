package quartz.compiler.semantics

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.semantics.symboltable.TypeTable
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.function.statement.VarDeclarationNode
import quartz.compiler.util.Function
import quartz.compiler.util.types.FunctionType

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.generateSymbolTable(): SymbolTable {
    val typeTable = TypeTable()
    structDeclarations.forEach { typeTable.add(it.name, it.type) }
    val symbolTable = SymbolTable(typeTable)
    fnDeclarations.forEach { symbolTable.addVar(it.name, FunctionType(Function(it.args.map { it.second }, it.returnType, false))) }
    externFnDeclarations.forEach { symbolTable.addVar(it.name, FunctionType(it.function)) }
    return symbolTable
}

fun FnDeclarationNode.localSymbolTable(symbolTable: SymbolTable): SymbolTable {
    val localSymbolTable = symbolTable.localSymbolTable()
    this.args.forEach { localSymbolTable.addVar(it.first, it.second) }
    return localSymbolTable
}

fun VarDeclarationNode.addTo(symbolTable: SymbolTable) {
    symbolTable.addVar(name, type ?: throw QuartzException("Unknown type for $this"))
}
