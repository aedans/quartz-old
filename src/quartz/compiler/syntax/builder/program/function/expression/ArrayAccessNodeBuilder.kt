package quartz.compiler.syntax.builder.program.function.expression

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.program.function.toNode
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.expression.BinaryOperatorNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ArrayAccessContext.toNode(expression: ExpressionNode): ExpressionNode {
    return BinaryOperatorNode(expression, expression().toNode(), BinaryOperatorNode.ID.ARRAY_ACCESS, null)
}
