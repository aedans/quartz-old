package quartz.compiler.syntax.builder.program.function.expression

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.expression.NumberLiteralNode
import quartz.compiler.syntax.tree.program.function.expression.StringLiteralNode
import quartz.compiler.util.types.Primitives

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.LiteralContext.toNode(): ExpressionNode {
    return when {
        CHAR() != null -> NumberLiteralNode(text, Primitives.char)
        INT() != null -> NumberLiteralNode(text, Primitives.int)
        DOUBLE() != null -> NumberLiteralNode(text, Primitives.double)
        STRING() != null -> StringLiteralNode(text.substring(1, text.length-1))
        else -> throw Exception("Error translating $this")
    }
}
