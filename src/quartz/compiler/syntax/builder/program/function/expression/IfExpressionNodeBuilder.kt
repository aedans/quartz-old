package quartz.compiler.syntax.builder.program.function.expression

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.program.function.toNode
import quartz.compiler.syntax.tree.program.function.expression.IfExpressionNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.IfExpressionContext.toNode(): IfExpressionNode {
    return IfExpressionNode(test.toNode(), ifTrue.toNode(), ifFalse.toNode(), null)
}
