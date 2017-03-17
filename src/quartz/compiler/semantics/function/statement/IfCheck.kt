package quartz.compiler.semantics.function.statement

import quartz.compiler.parser.nodes.StatementNode
import quartz.compiler.parser.nodes.statement.IfNode
import quartz.compiler.semantics.SemanticCheck
import quartz.compiler.semantics.function.ExpressionCheck
import quartz.compiler.semantics.function.StatementCheck
import quartz.compiler.semantics.symboltable.LocalSymbolTable
import quartz.compiler.semantics.symboltable.SymbolTable
import types.Primitives

/**
 * Created by Aedan Smith.
 */

class IfCheck(val statementCheck: StatementCheck, val expressionCheck: ExpressionCheck) : SemanticCheck<StatementNode> {
    override fun invoke(node: StatementNode, table: SymbolTable) {
        if (node !is IfNode)
            return

        expressionCheck(node.test, table)

        if (node.test.type == null) {
            node.test.type = Primitives.bool
        } else {
            if (!node.test.type!!.canCastTo(Primitives.bool)) {
                throw Exception("Could not cast $node to boolean")
            }
        }

        val localSymbolTable = LocalSymbolTable(table)

        for (statement in node.trueStatements) {
            statementCheck(statement, localSymbolTable)
        }
    }
}
