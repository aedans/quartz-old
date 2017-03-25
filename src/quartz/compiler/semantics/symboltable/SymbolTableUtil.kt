package quartz.compiler.semantics.symboltable

import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.generateSymbolTable(): SymbolTable {
    val globalSymbolTable = GlobalSymbolTable()
    structDeclarations.forEach { globalSymbolTable.addStruct(it) }
    fnDeclarations.forEach { globalSymbolTable.addFunction(Function(it)) }
    externFnDeclarations.forEach { globalSymbolTable.addFunction(it) }
    return globalSymbolTable
}
