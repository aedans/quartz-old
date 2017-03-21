package quartz.compiler.semantics.verifier.function.expression

import quartz.compiler.semantics.verifier.function.verify
import quartz.compiler.semantics.verifier.symboltable.SymbolTable
import quartz.compiler.semantics.verifier.verifyType
import quartz.compiler.syntax.tree.program.function.expression.IfExpressionNode

/**
 * Created by Aedan Smith.
 */

fun IfExpressionNode.verify(symbolTable: SymbolTable) {
    test.verify(symbolTable)
    ifTrue.verify(symbolTable)
    ifFalse.verify(symbolTable)

    verifyType(
            ifTrue.type,
            { ifTrue.type = it },
            ifFalse,
            { ifFalse = it },
            { "Invalid type for ${ifTrue}" }
    )

    verifyType(
            ifFalse.type,
            { ifFalse.type = it },
            ifTrue,
            { ifTrue = it },
            { "Invalid type for ${ifFalse}" }
    )

    verifyType(
            type,
            { type = it },
            ifTrue,
            { ifTrue = it },
            { "Invalid type for $this" }
    )
}
