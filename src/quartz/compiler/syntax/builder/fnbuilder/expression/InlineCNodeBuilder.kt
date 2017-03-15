package quartz.compiler.syntax.builder.fnbuilder.expression

import quartz.compiler.parser.parsers.parsenodes.InlineC
import quartz.compiler.syntax.nodes.enodes.InlineCNode
import quartz.compiler.syntax.type.types.Primitives

/**
 * Created by Aedan Smith.
 */

fun InlineC.toExpression(): InlineCNode {
    return InlineCNode(this.src, Primitives.void)
}
