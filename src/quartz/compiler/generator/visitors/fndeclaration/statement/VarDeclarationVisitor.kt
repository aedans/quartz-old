package quartz.compiler.generator.visitors.fndeclaration.statement

import quartz.compiler.generator.visitors.fndeclaration.visit
import quartz.compiler.generator.visitors.util.visit
import quartz.compiler.generator.visitors.util.visitName
import quartz.compiler.syntax.tree.program.function.statement.VarDeclarationNode

/**
 * Created by Aedan Smith.
 */

fun VarDeclarationNode.visit(string: StringBuilder) {
    (type ?: throw Exception("Unknown type for $this")).visit(string)
    string.append(' ')
    name.visitName(string)
    if (expression != null) {
        string.append(" = ")
        expression!!.visit(string)
    }
}
