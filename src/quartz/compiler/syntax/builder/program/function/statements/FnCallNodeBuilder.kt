package quartz.compiler.syntax.builder.program.function.statements

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.program.function.toNode
import quartz.compiler.syntax.tree.program.function.statement.FnCallNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.PrefixFnCallContext.toNode(): FnCallNode {
    return FnCallNode(
            name.text,
            expressionList().expression().map { it.toNode() }.toMutableList()
    )
}

fun QuartzParser.InfixFnCallContext.toNode(): FnCallNode {
    return FnCallNode(
            name.text,
            mutableListOf(
                    expr1.toNode(),
                    expr2.toNode()
            )
    )
}

fun QuartzParser.PostfixFnCallContext.toNode(): FnCallNode {
    return FnCallNode(
            name.text,
            mutableListOf(expression().toNode())
    )
}
