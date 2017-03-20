package quartz.compiler.semantics.function.expression

import quartz.compiler.semantics.SemanticAnalyzer
import quartz.compiler.semantics.checkType
import quartz.compiler.semantics.function.ExpressionAnalyzer
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.expression.OneArgOperatorNode

/**
 * Created by Aedan Smith.
 */

class OneArgOperatorAnalyzer(val expressionAnalyzer: ExpressionAnalyzer): SemanticAnalyzer<ExpressionNode> {
    override fun invoke(node: ExpressionNode, symbolTable: SymbolTable) {
        if (node !is OneArgOperatorNode)
            return

        expressionAnalyzer(node.expression, symbolTable)

        checkType(
                node.type,
                { node.type = it },
                node.expression,
                { node.expression = it },
                { "Invalid type for ${node.expression}" }
        )
    }
}
