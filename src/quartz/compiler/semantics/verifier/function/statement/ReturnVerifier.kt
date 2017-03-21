package quartz.compiler.semantics.verifier.function.statement

import quartz.compiler.semantics.verifier.function.verify
import quartz.compiler.semantics.verifier.symboltable.SymbolTable
import quartz.compiler.syntax.tree.program.function.statement.ReturnNode

/**
 * Created by Aedan Smith.
 */

fun ReturnNode.verify(symbolTable: SymbolTable) {
    expressionNode.verify(symbolTable)
}
