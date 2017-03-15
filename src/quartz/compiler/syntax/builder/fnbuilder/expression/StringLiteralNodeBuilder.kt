package quartz.compiler.syntax.builder.fnbuilder.expression

import quartz.compiler.parser.parsers.parsenodes.StringLiteral
import quartz.compiler.syntax.nodes.enodes.StringLiteralNode

/**
 * Created by Aedan Smith.
 */

fun StringLiteral.toExpression(): StringLiteralNode {
    return StringLiteralNode(this.value)
}
