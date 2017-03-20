package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.generator.Visitor
import quartz.compiler.generator.visitors.fndeclaration.ExpressionVisitor
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.expression.TwoArgOperatorNode

/**
 * Created by Aedan Smith.
 */

class TwoArgOperatorVisitor(val expressionVisitor: ExpressionVisitor): Visitor<ExpressionNode> {
    override fun invoke(node: ExpressionNode, string: StringBuilder, depth: Int) {
        if (node !is TwoArgOperatorNode)
            return

        when {
            node.id == TwoArgOperatorNode.ID.ARRAY_ACCESS -> {
                string.append('(')
                expressionVisitor(node.expr1, string, depth)
                string.append(")[")
                expressionVisitor(node.expr2, string, depth)
                string.append(']')
            }
            else -> {
                string.append('(')
                expressionVisitor(node.expr1, string, depth)
                string.append(')')
                string.append(node.id)
                string.append('(')
                expressionVisitor(node.expr2, string, depth)
                string.append(')')
            }
        }
    }
}
