package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.misc.TypealiasNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.TypealiasDeclarationContext.toNode(): TypealiasNode {
    return TypealiasNode(identifier().text, type().toType(), extern != null)
}
