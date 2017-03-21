package quartz.compiler.generator.visitors.fndeclaration

import quartz.compiler.generator.visitors.util.visit
import quartz.compiler.generator.visitors.util.visitName
import quartz.compiler.syntax.tree.program.FnDeclarationNode

/**
 * Created by Aedan Smith.
 */

fun FnDeclarationNode.visit(string: StringBuilder) {
    returnType.visit(string)
    string.append(' ')
    name.visitName(string)
    args.visit(string)
    string.appendln('{')
    statements.forEach {
        string.append("    ")
        it.visit(string, 1)
        string.appendln(";")
    }
    string.appendln('}')
}
