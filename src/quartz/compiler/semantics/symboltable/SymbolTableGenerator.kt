package quartz.compiler.semantics.symboltable

import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.util.Function
import quartz.compiler.util.types.FunctionType

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.generateSymbolTable(): SymbolTable {
    val globalSymbolTable = GlobalSymbolTable()
    structDeclarations.forEach { globalSymbolTable.structs.put(it.name, it.type) }
    fnDeclarations.forEach { globalSymbolTable.addVar(it.name, FunctionType(Function(it.args.map { it.second }, it.returnType, false))) }
    externFnDeclarations.forEach {
        globalSymbolTable.addVar(it.name, FunctionType(it.function))
    }
    return globalSymbolTable
}
