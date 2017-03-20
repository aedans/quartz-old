package quartz.compiler.semantics.function.statement

import quartz.compiler.semantics.SemanticAnalyzer
import quartz.compiler.semantics.checkType
import quartz.compiler.semantics.function.ExpressionAnalyzer
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.syntax.tree.program.function.statement.VarDeclarationNode
import quartz.compiler.util.Variable

/**
 * Created by Aedan Smith.
 */

class VarDeclarationAnalyzer(val expressionAnalyzer: ExpressionAnalyzer) : SemanticAnalyzer<StatementNode> {
    override fun invoke(node: StatementNode, symbolTable: SymbolTable) {
        if (node !is VarDeclarationNode)
            return

        expressionAnalyzer(node.expression, symbolTable)

        checkType(
                node.type,
                { node.type = it },
                node.expression,
                { node.expression = it },
                { "Invalid type for $node" }
        )

        symbolTable.add(node.name, Variable(node.name, node.type ?: throw Exception("Unknown type for $node")))
    }
}
