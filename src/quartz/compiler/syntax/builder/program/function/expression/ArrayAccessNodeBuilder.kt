package quartz.compiler.syntax.builder.program.function.expression

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.program.function.toNode
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.expression.TwoArgOperatorNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ArrayAccessContext.toNode(expression: ExpressionNode): ExpressionNode {
    return TwoArgOperatorNode(expression, expression().toNode(), TwoArgOperatorNode.ID.ARRAY_ACCESS, null)
}
