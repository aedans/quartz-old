package quartz.compiler.semantics.verifier

import quartz.compiler.semantics.verifier.function.verify
import quartz.compiler.semantics.verifier.symboltable.GlobalSymbolTable
import quartz.compiler.semantics.verifier.symboltable.LocalSymbolTable
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.util.function

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.verify() {
    val globalSymbolTable = GlobalSymbolTable()

    for (fnDeclarationNode in fnDeclarations) {
        globalSymbolTable.addFunction(fnDeclarationNode.function())
    }

    for (externalFunctionDeclaration in externFnDeclarations) {
        globalSymbolTable.addFunction(externalFunctionDeclaration)
    }

    for (fnDeclarationNode in fnDeclarations) {
        val localSymbolTable = LocalSymbolTable(globalSymbolTable)
        fnDeclarationNode.verify(localSymbolTable)
    }
}
