package quartz.compiler.syntax.builder.program.function

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.program.function.expression.toNode
import quartz.compiler.syntax.builder.program.function.statements.toNode
import quartz.compiler.syntax.builder.program.toNode
import quartz.compiler.syntax.tree.program.function.ExpressionNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ExpressionContext.toNode(): ExpressionNode {
    return if (infixFnCall() != null) {
        infixFnCall().toNode()
    } else if (atomicExpression() != null) {
        atomicExpression().toNode()
    } else {
        throw Exception("Error translating $this")
    }
}

fun QuartzParser.AtomicExpressionContext.toNode(): ExpressionNode {
    return if (literal() != null) {
        literal().toNode()
    } else if (inlineC() != null) {
        inlineC().toNode()
    } else if (identifier() != null) {
        identifier().toNode()
    } else if (prefixFnCall() != null) {
        prefixFnCall().toNode()
    } else if (postfixFnCall() != null) {
        postfixFnCall().toNode()
    } else if (ifExpression() != null){
        TODO("If expressions")
    } else if (expression() != null) {
        expression().toNode()
    } else {
        throw Exception("Error translating $this")
    }
}
