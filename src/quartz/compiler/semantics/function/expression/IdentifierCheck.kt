package quartz.compiler.semantics.function.expression

import quartz.compiler.tree.ExpressionNode
import quartz.compiler.tree.expression.IdentifierNode
import quartz.compiler.semantics.SemanticCheck

/**
 * Created by Aedan Smith.
 */

val identifierCheck: SemanticCheck<ExpressionNode> = { node, symbolTable ->
    if (node is IdentifierNode) {
        val expectedType = symbolTable[node.name].type
        if (node.type == null) {
            node.type = expectedType
        } else if (node.type != expectedType) {
            throw Exception("Expected $expectedType, found $node")
        }
    }
}
