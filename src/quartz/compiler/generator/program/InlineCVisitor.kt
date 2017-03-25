package quartz.compiler.generator.program

import quartz.compiler.syntax.tree.misc.InlineCNode

/**
 * Created by Aedan Smith.
 */

fun InlineCNode.visit(string: StringBuilder) {
    string.append(src)
}
