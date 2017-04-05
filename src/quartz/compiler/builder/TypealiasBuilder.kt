package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.misc.Typealias

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.TypealiasDeclarationContext.toNode(): Typealias {
    return Typealias(identifier().text, type().toType(), extern != null)
}
