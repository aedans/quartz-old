package quartz.compiler.semantics.verifier

import quartz.compiler.semantics.verifier.function.verify
import quartz.compiler.semantics.verifier.symboltable.GlobalSymbolTable
import quartz.compiler.semantics.verifier.symboltable.LocalSymbolTable
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.verify() {
    val globalSymbolTable = GlobalSymbolTable()

    fnDeclarations.forEach { globalSymbolTable.addFunction(Function(it.name, it.args.map { it.second }, it.returnType)) }

    externFnDeclarations.forEach { globalSymbolTable.addFunction(it) }

    for (fnDeclarationNode in fnDeclarations) {
        val localSymbolTable = LocalSymbolTable(globalSymbolTable)
        fnDeclarationNode.verify(localSymbolTable)
    }
}
