package quartz.compiler.semantics.verifier.function.statement

import quartz.compiler.semantics.verifier.function.verify
import quartz.compiler.semantics.verifier.symboltable.SymbolTable
import quartz.compiler.semantics.verifier.verifyType
import quartz.compiler.syntax.tree.program.function.statement.VarDeclarationNode
import quartz.compiler.util.Variable

/**
 * Created by Aedan Smith.
 */

fun VarDeclarationNode.verify(symbolTable: SymbolTable) {
    if (expression != null) {
        expression!!.verify(symbolTable)

        verifyType(
                type,
                { type = it },
                expression!!,
                { expression = it },
                { "Invalid type for $this" }
        )
    }

    symbolTable.add(name, Variable(name, type ?: throw Exception("Unknown type for $this")))
}
