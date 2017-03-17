package quartz.compiler.semantics.function

import quartz.compiler.parser.nodes.StatementNode
import quartz.compiler.semantics.SemanticCheck
import quartz.compiler.semantics.symboltable.SymbolTable

/**
 * Created by Aedan Smith.
 */

class StatementCheck : SemanticCheck<StatementNode> {
    val statementChecks = mutableListOf<SemanticCheck<StatementNode>>()

    override fun invoke(node: StatementNode, symbolTable: SymbolTable) {
        statementChecks.forEach { it(node, symbolTable) }
    }
}
