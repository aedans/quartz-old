package quartz.compiler.generator.visitors.fndeclaration

import quartz.compiler.generator.Visitor
import quartz.compiler.generator.visitors.fndeclaration.expression.CastVisitor
import quartz.compiler.generator.visitors.fndeclaration.expression.identifierVisitor
import quartz.compiler.generator.visitors.fndeclaration.expression.numberLiteralVisitor
import quartz.compiler.generator.visitors.fndeclaration.expression.stringLiteralVisitor
import quartz.compiler.generator.visitors.fndeclaration.statement.FnCallVisitor
import quartz.compiler.generator.visitors.fndeclaration.statement.ReturnVisitor
import quartz.compiler.generator.visitors.fndeclaration.statement.VarDeclarationVisitor
import quartz.compiler.generator.visitors.fndeclaration.statement.inlineCVisitor
import quartz.compiler.generator.visitors.util.argumentVisitor
import quartz.compiler.generator.visitors.util.nameVisitor
import quartz.compiler.generator.visitors.util.typeVisitor
import quartz.compiler.parser.nodes.FnDeclarationNode

/**
 * Created by Aedan Smith.
 */

class FnDeclarationVisitor(
        val expressionVisitor: ExpressionVisitor = ExpressionVisitor().apply expressionIterator@ { this.subVisitors.apply {
            add(numberLiteralVisitor)
            add(stringLiteralVisitor)
            add(inlineCVisitor)
            add(identifierVisitor)
            add(FnCallVisitor(this@expressionIterator))
            add(CastVisitor(this@expressionIterator))
        } },
        val statementVisitor: StatementVisitor = StatementVisitor().apply { this.subVisitors.apply {
            add(VarDeclarationVisitor(expressionVisitor))
            add(ReturnVisitor(expressionVisitor))
            add(FnCallVisitor(expressionVisitor))
            add(inlineCVisitor)
        } }
) : Visitor<FnDeclarationNode> {
    override fun invoke(node: FnDeclarationNode, string: StringBuilder) {
        typeVisitor(node.returnType, string)
        string.append(' ')
        nameVisitor(node.name, string)
        argumentVisitor(node.args, string)
        string.appendln('{')
        node.statements.forEach {
            string.append("    ")
            statementVisitor(it, string)
            string.appendln(";")
        }
        string.appendln('}')
    }
}
