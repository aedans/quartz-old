package quartz.compiler.semantics.verifier.function.expression

import quartz.compiler.semantics.verifier.function.verify
import quartz.compiler.semantics.verifier.symboltable.SymbolTable
import quartz.compiler.semantics.verifier.verifyType
import quartz.compiler.syntax.tree.program.function.expression.UnaryOperatorNode

/**
 * Created by Aedan Smith.
 */

fun UnaryOperatorNode.verify(symbolTable: SymbolTable) {
    expression.verify(symbolTable)

    verifyType(
            type,
            { type = it },
            expression,
            { expression = it },
            { "Invalid type for $expression" }
    )
}
