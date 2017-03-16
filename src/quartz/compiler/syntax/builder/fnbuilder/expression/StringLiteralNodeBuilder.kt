package quartz.compiler.syntax.builder.fnbuilder.expression

import quartz.compiler.parser.parsers.parsenodes.StringLiteralNode
import quartz.compiler.syntax.nodes.enodes.StringLiteral

/**
 * Created by Aedan Smith.
 */

fun StringLiteralNode.toExpression(): StringLiteral {
    return StringLiteral(value)
}
