package quartz.compiler.generator.visitors.fndeclaration.statement

import quartz.compiler.generator.Visitor
import quartz.compiler.generator.visitors.fndeclaration.ExpressionVisitor
import quartz.compiler.generator.visitors.util.nameVisitor
import quartz.compiler.parser.nodes.StatementNode
import quartz.compiler.parser.nodes.statement.FnCallNode

/**
 * Created by Aedan Smith.
 */

class FnCallVisitor(val expressionVisitor: ExpressionVisitor) : Visitor<StatementNode> {
    override fun invoke(node: StatementNode, string: StringBuilder, depth: Int) {
        if (node !is FnCallNode)
            return

        nameVisitor(node.name, string, depth)
        string.append('(')
        node.expressions.dropLast(1).forEach {
            expressionVisitor(it, string, depth)
            string.append(", ")
        }
        if (!node.expressions.isEmpty())
            expressionVisitor(node.expressions.last(), string, depth)
        string.append(')')
    }
}
