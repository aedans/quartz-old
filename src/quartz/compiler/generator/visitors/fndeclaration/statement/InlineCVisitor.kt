package quartz.compiler.generator.visitors.fndeclaration.statement

import quartz.compiler.syntax.tree.program.misc.InlineCNode

/**
 * Created by Aedan Smith.
 */

fun InlineCNode.visit(string: StringBuilder) {
    string.append(src)
}
