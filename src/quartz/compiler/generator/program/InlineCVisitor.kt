package quartz.compiler.generator.program

import quartz.compiler.syntax.tree.program.misc.InlineCNode

/**
 * Created by Aedan Smith.
 */

fun InlineCNode.visit(string: StringBuilder) {
    string.append(src)
}
