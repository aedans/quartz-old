package quartz.compiler.generator.visitors.fndeclaration.statement

import quartz.compiler.generator.visitors.fndeclaration.visit
import quartz.compiler.generator.visitors.util.visitName
import quartz.compiler.syntax.tree.program.function.statement.FnCallNode

/**
 * Created by Aedan Smith.
 */

fun FnCallNode.visit(string: StringBuilder) {
    name.visitName(string)
    string.append('(')
    expressions.dropLast(1).forEach {
        it.visit(string)
        string.append(", ")
    }
    if (!expressions.isEmpty())
        expressions.last().visit(string)
    string.append(')')
}
