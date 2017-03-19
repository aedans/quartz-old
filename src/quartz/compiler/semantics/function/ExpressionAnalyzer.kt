package quartz.compiler.semantics.function

import quartz.compiler.semantics.SemanticAnalyzer
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.syntax.tree.program.function.ExpressionNode

/**
 * Created by Aedan Smith.
 */

class ExpressionAnalyzer : SemanticAnalyzer<ExpressionNode> {
    val expressionChecks = mutableListOf<SemanticAnalyzer<ExpressionNode>>()

    override fun invoke(node: ExpressionNode, symbolTable: SymbolTable) {
        expressionChecks.forEach { it(node, symbolTable) }
    }
}
