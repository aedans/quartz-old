package quartz.compiler.generator.visitors.fndeclaration.statement

import quartz.compiler.generator.Visitor
import quartz.compiler.generator.visitors.fndeclaration.ExpressionVisitor
import quartz.compiler.generator.visitors.util.nameVisitor
import quartz.compiler.generator.visitors.util.typeVisitor
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.syntax.tree.program.function.statement.VarDeclarationNode

/**
 * Created by Aedan Smith.
 */

class VarDeclarationVisitor(val expressionVisitor: ExpressionVisitor) : Visitor<StatementNode> {
    override fun invoke(node: StatementNode, string: StringBuilder, depth: Int) {
        if (node !is VarDeclarationNode)
            return

        typeVisitor(node.type ?: throw Exception("Unknown type for $node"), string, depth)
        string.append(' ')
        nameVisitor(node.name, string, depth)
        if (node.expression != null) {
            string.append(" = ")
            expressionVisitor(node.expression!!, string, depth)
        }
    }
}
