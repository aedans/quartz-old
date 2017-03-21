package quartz.compiler.semantics.verifier.function.expression

import quartz.compiler.semantics.verifier.function.verify
import quartz.compiler.semantics.verifier.symboltable.SymbolTable
import quartz.compiler.semantics.verifier.verifyType
import quartz.compiler.syntax.tree.program.function.expression.TwoArgOperatorNode
import quartz.compiler.util.types.ArrayType
import quartz.compiler.util.types.Primitives

/**
 * Created by Aedan Smith.
 */

fun TwoArgOperatorNode.verify(symbolTable: SymbolTable) {
    expr1.verify(symbolTable)
    expr2.verify(symbolTable)

    if (id == TwoArgOperatorNode.ID.ARRAY_ACCESS) {
        verifyType(
                Primitives.int,
                { throw Exception("Could not access array with type ${expr2.type}") },
                expr2,
                { expr2 = it },
                { "Invalid type for $expr2" }
        )

        type = (expr1.type as? ArrayType)?.type ?: throw Exception("Could not access array of type ${expr1.type}")
    } else {
        verifyType(
                expr1.type,
                { expr1.type = it },
                expr2,
                { expr2 = it },
                { "Invalid type for $expr1" }
        )

        verifyType(
                expr2.type,
                { expr2.type = it },
                expr1,
                { expr1 = it },
                { "Invalid type for $expr2" }
        )

        verifyType(
                type,
                { type = it },
                expr1,
                { expr1 = it },
                { "Invalid type for $this" }
        )
    }
}
