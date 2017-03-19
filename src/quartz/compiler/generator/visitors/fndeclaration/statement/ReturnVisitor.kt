package quartz.compiler.generator.visitors.fndeclaration.statement

import quartz.compiler.generator.Visitor
import quartz.compiler.generator.visitors.fndeclaration.ExpressionVisitor
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.syntax.tree.program.function.statement.ReturnNode

/**
 * Created by Aedan Smith.
 */

class ReturnVisitor(val expressionVisitor: ExpressionVisitor) : Visitor<StatementNode> {
    override fun invoke(node: StatementNode, string: StringBuilder, depth: Int) {
        if (node !is ReturnNode)
            return

        string.append("return ")
        expressionVisitor(node.expressionNode, string, depth)
    }
}
