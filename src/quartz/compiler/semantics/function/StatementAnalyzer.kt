package quartz.compiler.semantics.function

import quartz.compiler.semantics.SemanticAnalyzer
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.tree.StatementNode

/**
 * Created by Aedan Smith.
 */

class StatementAnalyzer : SemanticAnalyzer<StatementNode> {
    val statementChecks = mutableListOf<SemanticAnalyzer<StatementNode>>()

    override fun invoke(node: StatementNode, symbolTable: SymbolTable) {
        statementChecks.forEach { it(node, symbolTable) }
    }
}
