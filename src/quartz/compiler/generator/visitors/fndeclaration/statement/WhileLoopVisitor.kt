package quartz.compiler.generator.visitors.fndeclaration.statement

import quartz.compiler.generator.Visitor
import quartz.compiler.generator.visitors.fndeclaration.ExpressionVisitor
import quartz.compiler.generator.visitors.fndeclaration.StatementVisitor
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.syntax.tree.program.function.statement.WhileLoopNode
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

class WhileLoopVisitor(val statementVisitor: StatementVisitor, val expressionVisitor: ExpressionVisitor) : Visitor<StatementNode> {
    override fun invoke(node: StatementNode, string: StringBuilder, depth: Int) {
        if (node !is WhileLoopNode)
            return

        string.append("while (")
        expressionVisitor(node.test, string, depth)
        string.appendln("){")
        for (statement in node.statements) {
            string.append("    " * (depth + 1))
            statementVisitor(statement, string, depth + 1)
            string.appendln(";")
        }
        string.append(("    " * depth) + "}")
    }
}
