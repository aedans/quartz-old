package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.generator.visitors.fndeclaration.visit
import quartz.compiler.generator.visitors.util.visit
import quartz.compiler.syntax.tree.program.function.expression.CastNode

/**
 * Created by Aedan Smith.
 */

fun CastNode.visit(string: StringBuilder) {
    string.append('(')
    (type ?: throw Exception("Unknown type for $this")).visit(string)
    string.append(") (")
    expression.visit(string)
    string.append(')')
}
