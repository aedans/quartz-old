package quartz.compiler.syntax.builder.fnbuilder.expression

import quartz.compiler.parser.parsers.parsenodes.NumberLiteralNode
import quartz.compiler.syntax.nodes.enodes.NumberLiteral

/**
 * Created by Aedan Smith.
 */

fun NumberLiteralNode.toExpression(): NumberLiteral {
    return NumberLiteral(value, type.toType())
}
