package quartz.compiler.syntax.builder.program.misc

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.tree.program.misc.InlineCNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.InlineCContext.toNode(): InlineCNode {
    return InlineCNode(text.substring(2, text.length-2))
}
