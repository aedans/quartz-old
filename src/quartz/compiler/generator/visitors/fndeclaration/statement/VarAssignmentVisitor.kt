package quartz.compiler.generator.visitors.fndeclaration.statement

import quartz.compiler.generator.visitors.fndeclaration.visit
import quartz.compiler.generator.visitors.util.visitName
import quartz.compiler.syntax.tree.program.function.statement.VarAssignmentNode

/**
 * Created by Aedan Smith.
 */

fun VarAssignmentNode.visit(string: StringBuilder) {
    name.visitName(string)
    string.append(" = ")
    expression.visit(string)
}
