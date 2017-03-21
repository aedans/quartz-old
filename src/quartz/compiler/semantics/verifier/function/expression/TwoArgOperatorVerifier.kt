package quartz.compiler.semantics.verifier.function.expression

import quartz.compiler.semantics.verifier.checkType
import quartz.compiler.semantics.verifier.function.verify
import quartz.compiler.semantics.verifier.symboltable.SymbolTable
import quartz.compiler.syntax.tree.program.function.expression.TwoArgOperatorNode
import quartz.compiler.util.types.Primitives
import quartz.compiler.util.types.QArray

/**
 * Created by Aedan Smith.
 */

fun TwoArgOperatorNode.verify(symbolTable: SymbolTable) {
    expr1.verify(symbolTable)
    expr2.verify(symbolTable)

    if (id == TwoArgOperatorNode.ID.ARRAY_ACCESS) {
        checkType(
                Primitives.int,
                { throw Exception("Could not access array with type ${expr2.type}") },
                expr2,
                { expr2 = it },
                { "Invalid type for $expr2" }
        )

        type = (expr1.type as? QArray)?.type ?: throw Exception("Could not access array of type ${expr1.type}")
    } else {
        checkType(
                expr1.type,
                { expr1.type = it },
                expr2,
                { expr2 = it },
                { "Invalid type for $expr1" }
        )

        checkType(
                expr2.type,
                { expr2.type = it },
                expr1,
                { expr1 = it },
                { "Invalid type for $expr2" }
        )

        checkType(
                type,
                { type = it },
                expr1,
                { expr1 = it },
                { "Invalid type for $this" }
        )
    }
}
