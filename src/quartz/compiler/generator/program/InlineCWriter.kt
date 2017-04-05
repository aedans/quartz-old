package quartz.compiler.generator.program

import quartz.compiler.generator.ProgramOutputStream
import quartz.compiler.tree.misc.InlineCNode

/**
 * Created by Aedan Smith.
 */

fun ProgramOutputStream.inlineC(inlineCNode: InlineCNode) {
    string(inlineCNode.src)
}
