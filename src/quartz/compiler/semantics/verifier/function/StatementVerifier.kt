package quartz.compiler.semantics.verifier.function

import quartz.compiler.semantics.verifier.function.statement.verify
import quartz.compiler.semantics.verifier.symboltable.SymbolTable
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.syntax.tree.program.function.statement.*
import quartz.compiler.syntax.tree.program.misc.InlineCNode

/**
 * Created by Aedan Smith.
 */

fun StatementNode.verify(symbolTable: SymbolTable) {
    when (this) {
        is InlineCNode -> { }
        is FnCallNode -> verify(symbolTable)
        is IfStatementNode -> verify(symbolTable)
        is VarDeclarationNode -> verify(symbolTable)
        is WhileLoopNode -> verify(symbolTable)
        is ReturnNode -> verify(symbolTable)
        else -> throw Exception("Unrecognized node $this")
    }
}
