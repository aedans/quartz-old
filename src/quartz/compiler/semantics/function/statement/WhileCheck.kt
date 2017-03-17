package quartz.compiler.semantics.function.statement

import quartz.compiler.semantics.SemanticCheck
import quartz.compiler.semantics.function.ExpressionCheck
import quartz.compiler.semantics.function.StatementCheck
import quartz.compiler.semantics.symboltable.LocalSymbolTable
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.tree.StatementNode
import quartz.compiler.tree.statement.WhileNode
import types.Primitives

/**
 * Created by Aedan Smith.
 */

class WhileCheck(val statementCheck: StatementCheck, val expressionCheck: ExpressionCheck) : SemanticCheck<StatementNode> {
    override fun invoke(node: StatementNode, table: SymbolTable) {
        if (node !is WhileNode)
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

        for (statement in node.statements) {
            statementCheck(statement, localSymbolTable)
        }
    }
}

