package quartz.compiler.semantics.verifier.function.expression

import quartz.compiler.semantics.verifier.checkType
import quartz.compiler.semantics.verifier.function.verify
import quartz.compiler.semantics.verifier.symboltable.SymbolTable
import quartz.compiler.syntax.tree.program.function.expression.OneArgOperatorNode

/**
 * Created by Aedan Smith.
 */

fun OneArgOperatorNode.verify(symbolTable: SymbolTable) {
    expression.verify(symbolTable)

    checkType(
            type,
            { type = it },
            expression,
            { expression = it },
            { "Invalid type for $expression" }
    )
}
