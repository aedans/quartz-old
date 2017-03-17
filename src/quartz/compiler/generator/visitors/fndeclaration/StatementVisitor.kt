package quartz.compiler.generator.visitors.fndeclaration

import quartz.compiler.generator.Visitor
import quartz.compiler.parser.nodes.StatementNode

/**
 * Created by Aedan Smith.
 */

class StatementVisitor : Visitor<StatementNode> {
    val subVisitors = mutableListOf<Visitor<StatementNode>>()

    override fun invoke(node: StatementNode, string: StringBuilder) {
        subVisitors.forEach { it(node, string) }
    }
}
