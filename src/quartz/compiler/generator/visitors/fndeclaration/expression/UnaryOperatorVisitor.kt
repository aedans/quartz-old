package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.generator.visitors.fndeclaration.visit
import quartz.compiler.syntax.tree.program.function.expression.UnaryOperatorNode

/**
 * Created by Aedan Smith.
 */

fun UnaryOperatorNode.visit(string: StringBuilder) {
    string.append(id)
    string.append('(')
    expression.visit(string)
    string.append(')')
}