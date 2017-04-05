package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.misc.InlineC

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.InlineCContext.toNode(): InlineC {
    return InlineC(text.substring(2, text.length-2))
}
