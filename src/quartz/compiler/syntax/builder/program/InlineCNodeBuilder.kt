package quartz.compiler.syntax.builder.program

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.tree.program.InlineCNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.InlineCContext.toNode(): InlineCNode {
    return InlineCNode(text.substring(2, text.length-2))
}
