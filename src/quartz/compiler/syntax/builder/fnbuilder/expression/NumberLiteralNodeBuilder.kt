package quartz.compiler.syntax.builder.fnbuilder.expression

import quartz.compiler.parser.parsers.parsenodes.NumberLiteral
import quartz.compiler.syntax.nodes.enodes.NumberLiteralNode

/**
 * Created by Aedan Smith.
 */

fun NumberLiteral.toExpression(): NumberLiteralNode {
    return NumberLiteralNode(this.value, this.type.toType())
}
