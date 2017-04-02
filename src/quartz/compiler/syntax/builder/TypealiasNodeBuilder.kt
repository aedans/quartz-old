package quartz.compiler.syntax.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.tree.misc.TypealiasNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.TypealiasDeclarationContext.toNode(): TypealiasNode {
    return TypealiasNode(identifier().text, type().toType(), false)
}

fun QuartzParser.ExternTypealiasDeclarationContext.toNode(): TypealiasNode {
    return TypealiasNode(identifier().text, type().toType(), true)
}
