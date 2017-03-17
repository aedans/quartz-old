package quartz.compiler.semantics.function

import quartz.compiler.parser.nodes.ExpressionNode
import quartz.compiler.semantics.SemanticCheck
import quartz.compiler.semantics.symboltable.SymbolTable

/**
 * Created by Aedan Smith.
 */

class ExpressionCheck : SemanticCheck<ExpressionNode> {
    val expressionChecks = mutableListOf<SemanticCheck<ExpressionNode>>()

    override fun invoke(node: ExpressionNode, symbolTable: SymbolTable) {
        expressionChecks.forEach { it(node, symbolTable) }
    }
}
