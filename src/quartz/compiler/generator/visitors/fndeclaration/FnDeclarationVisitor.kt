package quartz.compiler.generator.visitors.fndeclaration

import quartz.compiler.generator.Visitor
import quartz.compiler.generator.visitors.fndeclaration.expression.CastVisitor
import quartz.compiler.generator.visitors.fndeclaration.expression.identifierVisitor
import quartz.compiler.generator.visitors.fndeclaration.expression.numberLiteralVisitor
import quartz.compiler.generator.visitors.fndeclaration.expression.stringLiteralVisitor
import quartz.compiler.generator.visitors.fndeclaration.statement.*
import quartz.compiler.generator.visitors.util.argumentVisitor
import quartz.compiler.generator.visitors.util.nameVisitor
import quartz.compiler.generator.visitors.util.typeVisitor
import quartz.compiler.parser.nodes.FnDeclarationNode
import quartz.compiler.util.misc.times

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
        val statementVisitor: StatementVisitor = StatementVisitor().apply statementVisitor@ { this.subVisitors.apply {
            add(inlineCVisitor)
            add(VarDeclarationVisitor(expressionVisitor))
            add(ReturnVisitor(expressionVisitor))
            add(FnCallVisitor(expressionVisitor))
            add(IfVisitor(expressionVisitor, this@statementVisitor))
        } }
) : Visitor<FnDeclarationNode> {
    override fun invoke(node: FnDeclarationNode, string: StringBuilder, depth: Int) {
        typeVisitor(node.returnType, string, depth)
        string.append(' ')
        nameVisitor(node.name, string, depth)
        argumentVisitor(node.args, string, depth)
        string.appendln('{')
        node.statements.forEach {
            string.append("    " * (depth + 1))
            statementVisitor(it, string, depth + 1)
            string.appendln(";")
        }
        string.appendln('}')
    }
}
