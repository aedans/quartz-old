package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.generator.visitors.fndeclaration.visit
import quartz.compiler.generator.visitors.util.visitName
import quartz.compiler.syntax.tree.program.function.expression.MemberAccessNode

/**
 * Created by Aedan Smith.
 */

fun MemberAccessNode.visit(string: StringBuilder) {
    expression.visit(string)
    string.append('.')
    name.visitName(string)
}
