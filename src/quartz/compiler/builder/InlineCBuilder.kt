package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.UnknownType
import quartz.compiler.tree.declarations.InlineC

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.InlineCContext.toExpr(): InlineC {
    return InlineC(text.substring(2, text.length-2), UnknownType)
}
