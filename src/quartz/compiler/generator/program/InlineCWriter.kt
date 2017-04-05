package quartz.compiler.generator.program

import quartz.compiler.generator.ProgramOutputStream
import quartz.compiler.tree.misc.InlineC

/**
 * Created by Aedan Smith.
 */

fun ProgramOutputStream.inlineC(inlineCNode: InlineC) {
    string(inlineCNode.src)
}
