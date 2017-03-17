package quartz.compiler.generator.visitors.fndeclaration

import quartz.compiler.generator.Visitor
import quartz.compiler.generator.visitors.util.argumentVisitor
import quartz.compiler.generator.visitors.util.nameVisitor
import quartz.compiler.generator.visitors.util.typeVisitor
import quartz.compiler.parser.nodes.FnDeclarationNode

/**
 * Created by Aedan Smith.
 */

class FnPrototypeVisitor : Visitor<FnDeclarationNode> {
    override fun invoke(node: FnDeclarationNode, string: StringBuilder) {
        typeVisitor(node.returnType, string)
        string.append(' ')
        nameVisitor(node.name, string)
        argumentVisitor(node.args, string)
        string.appendln(";")
    }
}
