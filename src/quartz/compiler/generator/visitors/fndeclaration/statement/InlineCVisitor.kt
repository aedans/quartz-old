package quartz.compiler.generator.visitors.fndeclaration.statement

import quartz.compiler.syntax.tree.program.InlineCNode

/**
 * Created by Aedan Smith.
 */

fun InlineCNode.visit(string: StringBuilder) {
    string.append(src)
}
