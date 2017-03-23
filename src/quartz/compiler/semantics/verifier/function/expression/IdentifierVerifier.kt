package quartz.compiler.semantics.verifier.function.expression

import quartz.compiler.semantics.verifier.symboltable.SymbolTable
import quartz.compiler.syntax.tree.program.function.expression.IdentifierNode

/**
 * Created by Aedan Smith.
 */

fun IdentifierNode.verify(symbolTable: SymbolTable) {
    val expectedType = symbolTable[name]?.type
        ?: throw Exception("Could not find variable $name")
    if (type == null) {
        type = expectedType
    } else if (type != expectedType) {
        throw Exception("Expected $expectedType, found $this")
    }
}
