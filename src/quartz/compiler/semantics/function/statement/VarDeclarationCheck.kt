package quartz.compiler.semantics.function.statement

import quartz.compiler.parser.nodes.StatementNode
import quartz.compiler.parser.nodes.statement.VarDeclarationNode
import quartz.compiler.semantics.SemanticCheck
import quartz.compiler.semantics.checkType
import quartz.compiler.semantics.function.ExpressionCheck
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.util.Variable

/**
 * Created by Aedan Smith.
 */

class VarDeclarationCheck(val expressionCheck: ExpressionCheck) : SemanticCheck<StatementNode> {
    override fun invoke(node: StatementNode, symbolTable: SymbolTable) {
        if (node !is VarDeclarationNode)
            return

        expressionCheck(node.expression, symbolTable)

        checkType(
                node.type,
                { node.type = it },
                node.expression,
                { node.expression = it },
                { "Unknown type for $node" }
        )

        symbolTable.add(node.name, Variable(node.name, node.type ?: throw Exception("Unknown type for $node")))
    }
}
