package quartz.compiler.syntax.builder.program.function.expression

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.expression.NumberLiteralNode
import quartz.compiler.syntax.tree.program.function.expression.StringLiteralNode
import types.Primitives

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.LiteralContext.toNode(): ExpressionNode {
    return if (CHAR() != null) {
        TODO("Char literals")
    } else if (INT() != null) {
        NumberLiteralNode(text, Primitives.int)
    } else if (DOUBLE() != null) {
        NumberLiteralNode(text, Primitives.double)
    } else if (STRING() != null) {
        StringLiteralNode(text.substring(1, text.length-1))
    } else {
        throw Exception("Error translating $this")
    }
}
