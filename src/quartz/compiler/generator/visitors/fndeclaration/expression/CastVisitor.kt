package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.generator.Visitor
import quartz.compiler.generator.visitors.fndeclaration.ExpressionVisitor
import quartz.compiler.generator.visitors.util.typeVisitor
import quartz.compiler.tree.ExpressionNode
import quartz.compiler.tree.expression.CastNode

/**
 * Created by Aedan Smith.
 */

class CastVisitor(val expressionVisitor: ExpressionVisitor): Visitor<ExpressionNode> {
    override fun invoke(node: ExpressionNode, string: StringBuilder, depth: Int) {
        if (node !is CastNode)
            return

        string.append('(')
        typeVisitor(node.type ?: throw Exception("Unknown type for $node"), string, depth)
        string.append(") (")
        expressionVisitor(node.expression, string, depth)
        string.append(')')
    }
}
