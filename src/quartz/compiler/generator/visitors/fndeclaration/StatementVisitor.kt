package quartz.compiler.generator.visitors.fndeclaration

import quartz.compiler.generator.Visitor
import quartz.compiler.syntax.tree.program.function.StatementNode

/**
 * Created by Aedan Smith.
 */

class StatementVisitor : Visitor<StatementNode> {
    val subVisitors = mutableListOf<Visitor<StatementNode>>()

    override fun invoke(node: StatementNode, string: StringBuilder, depth: Int) {
        subVisitors.forEach { it(node, string, depth) }
    }
}
