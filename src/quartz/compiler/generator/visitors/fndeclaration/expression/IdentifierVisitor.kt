package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.generator.visitors.util.visitName
import quartz.compiler.syntax.tree.program.function.expression.IdentifierNode

/**
 * Created by Aedan Smith.
 */

fun IdentifierNode.visit(string: StringBuilder) {
    name.visitName(string)
}
