package quartz.compiler.semantics.function.statement

import quartz.compiler.semantics.SemanticAnalyzer
import quartz.compiler.semantics.function.ExpressionAnalyzer
import quartz.compiler.semantics.function.StatementAnalyzer
import quartz.compiler.semantics.symboltable.LocalSymbolTable
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.syntax.tree.program.function.statement.IfStatementNode
import quartz.compiler.util.types.Primitives

/**
 * Created by Aedan Smith.
 */

class IfAnalyzer(val statementAnalyzer: StatementAnalyzer, val expressionAnalyzer: ExpressionAnalyzer) : SemanticAnalyzer<StatementNode> {
    override fun invoke(node: StatementNode, table: SymbolTable) {
        if (node !is IfStatementNode)
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

        for (statement in node.trueStatements) {
            statementAnalyzer(statement, localSymbolTable)
        }
        for (statement in node.falseStatements) {
            statementAnalyzer(statement, localSymbolTable)
        }
    }
}

