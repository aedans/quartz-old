package quartz.compiler.syntax.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.tree.misc.InlineCNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.InlineCContext.toNode(): InlineCNode {
    return InlineCNode(text.substring(2, text.length-2))
}
