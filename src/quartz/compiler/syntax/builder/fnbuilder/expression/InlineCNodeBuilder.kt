package quartz.compiler.syntax.builder.fnbuilder.expression

import quartz.compiler.parser.parsers.parsenodes.InlineCNode
import quartz.compiler.syntax.nodes.enodes.InlineC
import quartz.compiler.syntax.type.types.Primitives

/**
 * Created by Aedan Smith.
 */

fun InlineCNode.toExpression(): InlineC {
    return InlineC(src, Primitives.void)
}
