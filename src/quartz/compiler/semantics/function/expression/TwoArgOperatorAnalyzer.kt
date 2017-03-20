package quartz.compiler.semantics.function.expression

import quartz.compiler.semantics.SemanticAnalyzer
import quartz.compiler.semantics.checkType
import quartz.compiler.semantics.function.ExpressionAnalyzer
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.expression.TwoArgOperatorNode
import quartz.compiler.util.types.Primitives
import quartz.compiler.util.types.QArray

/**
 * Created by Aedan Smith.
 */

class TwoArgOperatorAnalyzer(val expressionAnalyzer: ExpressionAnalyzer): SemanticAnalyzer<ExpressionNode> {
    override fun invoke(node: ExpressionNode, symbolTable: SymbolTable) {
        if (node !is TwoArgOperatorNode)
            return

        expressionAnalyzer(node.expr1, symbolTable)
        expressionAnalyzer(node.expr2, symbolTable)

        if (node.id == TwoArgOperatorNode.ID.ARRAY_ACCESS) {
            checkType(
                    Primitives.int,
                    { throw Exception("Could not access array with type ${node.expr2.type}") },
                    node.expr2,
                    { node.expr2 = it },
                    { "Invalid type for ${node.expr2}" }
            )

            node.type = (node.expr1.type as? QArray)?.type ?: throw Exception("Could not access array of type ${node.expr1.type}")
        } else {
            checkType(
                    node.expr1.type,
                    { node.expr1.type = it },
                    node.expr2,
                    { node.expr2 = it },
                    { "Invalid type for ${node.expr1}" }
            )

            checkType(
                    node.expr2.type,
                    { node.expr2.type = it },
                    node.expr1,
                    { node.expr1 = it },
                    { "Invalid type for ${node.expr2}" }
            )

            checkType(
                    node.type,
                    { node.type = it },
                    node.expr1,
                    { node.expr1 = it },
                    { "Invalid type for $node" }
            )
        }
    }
}
