package quartz.compiler.generator.visitors

import quartz.compiler.generator.Visitor
import quartz.compiler.generator.visitors.fndeclaration.FnDeclarationVisitor
import quartz.compiler.generator.visitors.fndeclaration.FnPrototypeVisitor
import quartz.compiler.generator.visitors.fndeclaration.statement.inlineCVisitor
import quartz.compiler.syntax.tree.ProgramNode

/**
 * Created by Aedan Smith.
 */

class ProgramVisitor(
        val fnPrototypeVisitor: FnPrototypeVisitor = FnPrototypeVisitor(),
        val fnDeclarationVisitor: FnDeclarationVisitor = FnDeclarationVisitor()
) : Visitor<ProgramNode> {
    override fun invoke(node: ProgramNode, string: StringBuilder, depth: Int) {
        node.fnDeclarations.forEach { fnPrototypeVisitor(it, string, 0) }
        node.inlineCNodes.forEach { inlineCVisitor(it, string, 0) }
        node.fnDeclarations.forEach {
            string.appendln()
            fnDeclarationVisitor(it, string, 0)
        }
    }
}
