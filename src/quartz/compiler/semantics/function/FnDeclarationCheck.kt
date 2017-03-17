package quartz.compiler.semantics.function

import quartz.compiler.parser.nodes.ProgramNode
import quartz.compiler.semantics.SemanticCheck
import quartz.compiler.semantics.function.expression.identifierCheck
import quartz.compiler.semantics.function.statement.FnCallCheck
import quartz.compiler.semantics.function.statement.VarDeclarationCheck
import quartz.compiler.semantics.symboltable.LocalSymbolTable
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.util.function

/**
 * Created by Aedan Smith.
 */

class FnDeclarationCheck(
        val expressionCheck: ExpressionCheck = ExpressionCheck().apply expressionCheck@ { this.expressionChecks.apply {
            add(identifierCheck)
            add(FnCallCheck(this@expressionCheck))
        } },
        val statementCheck: StatementCheck = StatementCheck().apply { this.statementChecks.apply {
            add(VarDeclarationCheck(expressionCheck))
            add(FnCallCheck(expressionCheck))
        } }
) : SemanticCheck<ProgramNode> {
    override fun invoke(node: ProgramNode, symbolTable: SymbolTable) {
        for (fnDeclarationNode in node.fnDeclarations) {
            symbolTable.getGlobalSymbolTable().addFunction(fnDeclarationNode.function())
        }

        for (fnDeclarationNode in node.fnDeclarations) {
            val localSymbolTable = LocalSymbolTable(symbolTable)
            for (statementNode in fnDeclarationNode.statements) {
                statementCheck(statementNode, localSymbolTable)
            }
        }
    }
}
