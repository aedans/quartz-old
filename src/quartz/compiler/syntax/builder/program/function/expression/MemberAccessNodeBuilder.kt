package quartz.compiler.syntax.builder.program.function.expression

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.expression.MemberAccessNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.MemberAccessContext.toNode(expression: ExpressionNode): MemberAccessNode {
    return MemberAccessNode(identifier().text, null, expression)
}
