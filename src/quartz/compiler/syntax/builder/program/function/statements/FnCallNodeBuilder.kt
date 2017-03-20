package quartz.compiler.syntax.builder.program.function.statements

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.program.function.toNode
import quartz.compiler.syntax.tree.program.function.statement.FnCallNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.PrefixCallExpressionContext.toNode(): FnCallNode {
    return FnCallNode(
            identifier().text,
            expressionList().expression().map { it.toNode() }.toMutableList()
    )
}

fun QuartzParser.InfixCallExpressionContext.toNode(): FnCallNode {
    val args = expressionList().expression().map { it.toNode() }.toMutableList()
    args.add(0, atomicExpression().toNode())
    return FnCallNode(
            identifier().text,
            args
    )
}
