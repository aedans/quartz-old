package quartz.compiler.semantics.function.statement

import quartz.compiler.semantics.SemanticAnalyzer
import quartz.compiler.semantics.function.ExpressionAnalyzer
import quartz.compiler.semantics.function.StatementAnalyzer
import quartz.compiler.semantics.symboltable.LocalSymbolTable
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.tree.StatementNode
import quartz.compiler.tree.statement.WhileNode
import types.Primitives

/**
 * Created by Aedan Smith.
 */

class WhileAnalyzer(val statementAnalyzer: StatementAnalyzer, val expressionAnalyzer: ExpressionAnalyzer) : SemanticAnalyzer<StatementNode> {
    override fun invoke(node: StatementNode, table: SymbolTable) {
        if (node !is WhileNode)
            return

        expressionAnalyzer(node.test, table)

        if (node.test.type == null) {
            node.test.type = Primitives.bool
        } else {
            if (!node.test.type!!.canCastTo(Primitives.bool)) {
                throw Exception("Could not cast $node to boolean")
            }
        }

        val localSymbolTable = LocalSymbolTable(table)

        for (statement in node.statements) {
            statementAnalyzer(statement, localSymbolTable)
        }
    }
}
