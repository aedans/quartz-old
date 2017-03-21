package quartz.compiler.semantics.verifier.function.statement

import quartz.compiler.semantics.verifier.function.verify
import quartz.compiler.semantics.verifier.symboltable.LocalSymbolTable
import quartz.compiler.semantics.verifier.symboltable.SymbolTable
import quartz.compiler.syntax.tree.program.function.statement.IfStatementNode
import quartz.compiler.util.types.Primitives

/**
 * Created by Aedan Smith.
 */

fun IfStatementNode.verify(symbolTable: SymbolTable) {
    test.verify(symbolTable)

    if (test.type == null) {
        test.type = Primitives.bool
    } else {
        if (!test.type!!.canCastTo(Primitives.bool)) {
            throw Exception("Could not cast $this to boolean")
        }
    }

    val localSymbolTable = LocalSymbolTable(symbolTable)

    for (statement in trueStatements) {
        statement.verify(localSymbolTable)
    }
    for (statement in falseStatements) {
        statement.verify(localSymbolTable)
    }
}

