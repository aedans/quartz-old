package quartz.compiler.semantics

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.symboltable.GlobalSymbolTable
import quartz.compiler.semantics.symboltable.LocalSymbolTable
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.function.statement.VarDeclarationNode
import quartz.compiler.util.Function
import quartz.compiler.util.types.FunctionType

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.generateSymbolTable(): SymbolTable {
    val globalSymbolTable = GlobalSymbolTable()
    structDeclarations.forEach { globalSymbolTable.structs.put(it.name, it.type) }
    fnDeclarations.forEach { globalSymbolTable.addVar(it.name, FunctionType(Function(it.args.map { it.second }, it.returnType, false))) }
    externFnDeclarations.forEach { globalSymbolTable.addVar(it.name, FunctionType(it.function)) }
    return globalSymbolTable
}

fun FnDeclarationNode.localSymbolTable(symbolTable: SymbolTable): LocalSymbolTable {
    val localSymbolTable = LocalSymbolTable(symbolTable)
    this.args.forEach { localSymbolTable.addVar(it.first, it.second) }
    return localSymbolTable
}

fun VarDeclarationNode.addTo(symbolTable: SymbolTable) {
    symbolTable.addVar(name, type ?: throw QuartzException("Unknown type for $this"))
}
