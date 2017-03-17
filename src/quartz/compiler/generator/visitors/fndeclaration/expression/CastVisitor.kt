package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.generator.Visitor
import quartz.compiler.generator.visitors.fndeclaration.ExpressionVisitor
import quartz.compiler.generator.visitors.util.typeVisitor
import quartz.compiler.parser.nodes.ExpressionNode
import quartz.compiler.parser.nodes.expression.CastNode

/**
 * Created by Aedan Smith.
 */

class CastVisitor(val expressionVisitor: ExpressionVisitor): Visitor<ExpressionNode> {
    override fun invoke(node: ExpressionNode, string: StringBuilder) {
        if (node !is CastNode)
            return

        string.append('(')
        typeVisitor(node.type ?: throw Exception("Unknown type for $node"), string)
        string.append(") (")
        expressionVisitor(node.expression, string)
        string.append(')')
    }
}
