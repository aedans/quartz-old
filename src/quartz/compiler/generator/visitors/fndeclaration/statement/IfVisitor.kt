package quartz.compiler.generator.visitors.fndeclaration.statement

import quartz.compiler.generator.Visitor
import quartz.compiler.generator.visitors.fndeclaration.ExpressionVisitor
import quartz.compiler.generator.visitors.fndeclaration.StatementVisitor
import quartz.compiler.tree.StatementNode
import quartz.compiler.tree.statement.IfNode
import quartz.compiler.util.misc.times

/**
 * Created by Aedan Smith.
 */

class IfVisitor(val expressionVisitor: ExpressionVisitor, val statementVisitor: StatementVisitor) : Visitor<StatementNode> {
    override fun invoke(node: StatementNode, string: StringBuilder, depth: Int) {
        if (node !is IfNode)
            return

        string.append("if (")
        expressionVisitor(node.test, string, depth)
        string.appendln(") {")
        for (statement in node.trueStatements) {
            string.append("    " * (depth + 1))
            statementVisitor(statement, string, depth + 1)
            string.appendln(";")
        }
        string.appendln(("    " * depth) + "} else {")
        for (statement in node.falseStatements) {
            string.append("    " * (depth + 1))
            statementVisitor(statement, string, depth + 1)
            string.appendln(";")
        }
        string.append(("    " * depth) + "}")
    }
}
