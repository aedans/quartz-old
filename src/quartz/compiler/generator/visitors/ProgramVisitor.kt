package quartz.compiler.generator.visitors

import quartz.compiler.generator.Visitor
import quartz.compiler.generator.visitors.fndeclaration.FnDeclarationVisitor
import quartz.compiler.generator.visitors.fndeclaration.FnPrototypeVisitor
import quartz.compiler.generator.visitors.fndeclaration.statement.inlineCVisitor
import quartz.compiler.parser.nodes.ProgramNode

/**
 * Created by Aedan Smith.
 */

class ProgramVisitor(
        val fnPrototypeVisitor: FnPrototypeVisitor = FnPrototypeVisitor(),
        val fnDeclarationVisitor: FnDeclarationVisitor = FnDeclarationVisitor()
) : Visitor<ProgramNode> {
    override fun invoke(node: ProgramNode, string: StringBuilder) {
        node.fnDeclarations.forEach { fnPrototypeVisitor(it, string) }
        node.inlineCNodes.forEach { inlineCVisitor(it, string) }
        node.fnDeclarations.forEach {
            string.appendln()
            fnDeclarationVisitor(it, string)
        }
    }
}
