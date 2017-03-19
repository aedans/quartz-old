package quartz.compiler.semantics.function

import quartz.compiler.semantics.SemanticAnalyzer
import quartz.compiler.semantics.function.expression.identifierAnalyzer
import quartz.compiler.semantics.function.statement.FnCallAnalyzer
import quartz.compiler.semantics.function.statement.IfAnalyzer
import quartz.compiler.semantics.function.statement.VarDeclarationAnalyzer
import quartz.compiler.semantics.function.statement.WhileAnalyzer
import quartz.compiler.semantics.symboltable.LocalSymbolTable
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.util.Variable
import quartz.compiler.util.function

/**
 * Created by Aedan Smith.
 */

class FnDeclarationAnalyzer(
        val expressionAnalyzer: ExpressionAnalyzer = ExpressionAnalyzer().apply expressionCheck@ { this.expressionChecks.apply {
            add(identifierAnalyzer)
            add(FnCallAnalyzer(this@expressionCheck))
        } },
        val statementAnalyzer: StatementAnalyzer = StatementAnalyzer().apply statementCheck@ { this.statementChecks.apply {
            add(VarDeclarationAnalyzer(expressionAnalyzer))
            add(FnCallAnalyzer(expressionAnalyzer))
            add(IfAnalyzer(this@statementCheck, expressionAnalyzer))
            add(WhileAnalyzer(this@statementCheck, expressionAnalyzer))
        } }
) : SemanticAnalyzer<ProgramNode> {
    override fun invoke(node: ProgramNode, symbolTable: SymbolTable) {
        for (fnDeclarationNode in node.fnDeclarations) {
            symbolTable.getGlobalSymbolTable().addFunction(fnDeclarationNode.function())
        }

        for (fnDeclarationNode in node.fnDeclarations) {
            val localSymbolTable = LocalSymbolTable(symbolTable)
            for (arg in fnDeclarationNode.args) {
                localSymbolTable.add(arg.first, Variable(arg.first, arg.second))
            }
            for (statementNode in fnDeclarationNode.statements) {
                statementAnalyzer(statementNode, localSymbolTable)
            }
        }
    }
}
