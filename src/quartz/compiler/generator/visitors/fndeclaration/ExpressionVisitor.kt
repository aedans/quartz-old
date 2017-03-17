package quartz.compiler.generator.visitors.fndeclaration

import quartz.compiler.generator.Visitor
import quartz.compiler.parser.nodes.ExpressionNode

/**
 * Created by Aedan Smith.
 */

class ExpressionVisitor : Visitor<ExpressionNode> {
    val subVisitors = mutableListOf<Visitor<ExpressionNode>>()

    override fun invoke(node: ExpressionNode, string: StringBuilder, depth: Int) {
        subVisitors.forEach { it(node, string, depth) }
    }
}
