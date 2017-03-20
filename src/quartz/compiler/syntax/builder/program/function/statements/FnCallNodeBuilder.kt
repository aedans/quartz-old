package quartz.compiler.syntax.builder.program.function.statements

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.program.function.toNode
import quartz.compiler.syntax.tree.program.function.ExpressionNode
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

// TODO: Shorten by getting IntelliJ to understand what packages are
fun QuartzParser.InfixCallExpressionContext.toNode(): FnCallNode {
    val args = infixCall().expressionList().expression().map { it.toNode() }.toMutableList()
    args.add(0, expression().toNode())
    return FnCallNode(
            infixCall().identifier().text,
            args
    )
}

fun QuartzParser.InfixCallContext.toNode(expression: ExpressionNode): FnCallNode {
    val args = expressionList().expression().map { it.toNode() }.toMutableList()
    args.add(0, expression)
    return FnCallNode(
            identifier().text,
            args
    )
}
