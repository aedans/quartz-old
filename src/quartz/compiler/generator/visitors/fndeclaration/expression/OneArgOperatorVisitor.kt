package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.generator.Visitor
import quartz.compiler.generator.visitors.fndeclaration.ExpressionVisitor
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.expression.OneArgOperatorNode

/**
 * Created by Aedan Smith.
 */

class OneArgOperatorVisitor(val expressionVisitor: ExpressionVisitor): Visitor<ExpressionNode> {
    override fun invoke(node: ExpressionNode, string: StringBuilder, depth: Int) {
        if (node !is OneArgOperatorNode)
            return

        string.append(node.id)
        string.append('(')
        expressionVisitor(node.expression, string, depth)
        string.append(')')
    }
}
