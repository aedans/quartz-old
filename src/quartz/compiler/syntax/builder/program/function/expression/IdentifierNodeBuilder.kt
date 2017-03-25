package quartz.compiler.syntax.builder.program.function.expression

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.tree.program.function.expression.IdentifierNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.IdentifierContext.toNode(): IdentifierNode {
    return IdentifierNode(text, null)
}
