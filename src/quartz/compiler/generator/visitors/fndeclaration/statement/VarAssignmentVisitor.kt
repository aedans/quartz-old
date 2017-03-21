package quartz.compiler.generator.visitors.fndeclaration.statement

import quartz.compiler.generator.Visitor
import quartz.compiler.generator.visitors.fndeclaration.ExpressionVisitor
import quartz.compiler.generator.visitors.util.nameVisitor
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.syntax.tree.program.function.statement.VarAssignmentNode

/**
 * Created by Aedan Smith.
 */

class VarAssignmentVisitor(val expressionVisitor: ExpressionVisitor) : Visitor<StatementNode> {
    override fun invoke(node: StatementNode, string: StringBuilder, depth: Int) {
        if (node !is VarAssignmentNode)
            return

        nameVisitor(node.name, string, depth)
        string.append(" = ")
        expressionVisitor(node.expression, string, depth)
    }
}
