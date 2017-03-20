package quartz.compiler.syntax.builder.program.function

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.program.function.expression.toNode
import quartz.compiler.syntax.builder.program.function.statements.toNode
import quartz.compiler.syntax.builder.program.toNode
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.expression.OneArgOperatorNode
import quartz.compiler.syntax.tree.program.function.expression.TwoArgOperatorNode
import quartz.compiler.syntax.tree.program.function.statement.FnCallNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ExpressionContext.toNode(): ExpressionNode {
    return disjunction().toNode()
}

fun QuartzParser.DisjunctionContext.toNode(): ExpressionNode {
    return if (disjunction() == null) {
        conjunction().toNode()
    } else {
        TwoArgOperatorNode(conjunction().toNode(), disjunction().toNode(), TwoArgOperatorNode.ID.OR, null)
    }
}

fun QuartzParser.ConjunctionContext.toNode(): ExpressionNode {
    return if (conjunction() == null) {
        equalityComparison().toNode()
    } else {
        TwoArgOperatorNode(equalityComparison().toNode(), conjunction().toNode(), TwoArgOperatorNode.ID.AND, null)
    }
}

fun QuartzParser.EqualityComparisonContext.toNode(): ExpressionNode {
    return if (equalityComparison() == null) {
        comparison().toNode()
    } else {
        TwoArgOperatorNode(comparison().toNode(), equalityComparison().toNode(), equalityOperation().ID, null)
    }
}

fun QuartzParser.ComparisonContext.toNode(): ExpressionNode {
    return if (comparison() == null) {
        additiveExpression().toNode()
    } else {
        TwoArgOperatorNode(additiveExpression().toNode(), comparison().toNode(), comparisonOperation().ID, null)
    }
}

fun QuartzParser.AdditiveExpressionContext.toNode(): ExpressionNode {
    return if (additiveExpression() == null) {
        multiplicativeExpression().toNode()
    } else {
        TwoArgOperatorNode(multiplicativeExpression().toNode(), additiveExpression().toNode(), additiveOperation().ID, null)
    }
}

fun QuartzParser.MultiplicativeExpressionContext.toNode(): ExpressionNode {
    return if (multiplicativeExpression() == null) {
        prefixExpression().toNode()
    } else {
        TwoArgOperatorNode(prefixExpression().toNode(), multiplicativeExpression().toNode(), multiplicativeOperation().ID, null)
    }
}

fun QuartzParser.PrefixExpressionContext.toNode(operations: List<QuartzParser.PrefixOperationContext>? = prefixOperation()): ExpressionNode {
    return if (operations == null || operations.isEmpty()) {
        postfixExpression().toNode()
    } else if (operations.size == 1) {
        operations[0].toNode(postfixExpression().toNode())
    } else {
        operations.last().toNode(toNode(operations.dropLast(1)))
    }
}

fun QuartzParser.PrefixOperationContext.toNode(expression: ExpressionNode): ExpressionNode {
    return OneArgOperatorNode(expression, when (text) {
        "-" -> OneArgOperatorNode.ID.NEGATE
        "!" -> OneArgOperatorNode.ID.INVERT
        else -> throw Exception("Unrecognized prefix operator $text")
    }, null)
}

fun QuartzParser.PostfixExpressionContext.toNode(operations: List<QuartzParser.PostfixOperationContext>? = postfixOperation()): ExpressionNode {
    return if (operations == null || operations.isEmpty()) {
        infixCallExpression().toNode()
    } else if (operations.size == 1) {
        operations[0].toNode(infixCallExpression().toNode())
    } else {
        operations.last().toNode(toNode(operations.dropLast(1)))
    }
}

fun QuartzParser.PostfixOperationContext.toNode(expression: ExpressionNode): ExpressionNode {
    return TwoArgOperatorNode(expression, expression().toNode(), TwoArgOperatorNode.ID.ARRAY_ACCESS, null)
}

fun QuartzParser.InfixCallExpressionContext.toNode(): ExpressionNode {
    return if (expressionList() == null) {
        atomicExpression().toNode()
    } else {
        FnCallNode(identifier().text, expressionList().expression().map { it.toNode() }.toMutableList())
    }
}

fun QuartzParser.AtomicExpressionContext.toNode(): ExpressionNode {
    return when {
        expression() != null -> expression().toNode()
        prefixCallExpression() != null -> prefixCallExpression().toNode()
        identifier() != null -> identifier().toNode()
        inlineC() != null -> inlineC().toNode()
        literal() != null -> literal().toNode()
        else -> throw Exception("Unrecognized atomic expression $text")
    }
}

val QuartzParser.EqualityOperationContext.ID: TwoArgOperatorNode.ID
    get() = when (text) {
        "==" -> TwoArgOperatorNode.ID.EQUALS
        "!=" -> TwoArgOperatorNode.ID.NOT_EQUALS
        else -> throw Exception("Unrecognized equality operator $text")
    }

val QuartzParser.ComparisonOperationContext.ID: TwoArgOperatorNode.ID
    get() = when (text) {
        ">" -> TwoArgOperatorNode.ID.GREATER_THAN
        "<" -> TwoArgOperatorNode.ID.LESS_THAN
        ">=" -> TwoArgOperatorNode.ID.GREATER_THAN_OR_EQUALS
        "<=" -> TwoArgOperatorNode.ID.LESS_THAN_OR_EQUALS
        else -> throw Exception("Unrecognized comparison operator $text")
    }

val QuartzParser.AdditiveOperationContext.ID: TwoArgOperatorNode.ID
    get() = when (text) {
        "+" -> TwoArgOperatorNode.ID.ADD
        "-" -> TwoArgOperatorNode.ID.SUBTRACT
        else -> throw Exception("Unrecognized additive operator $text")
    }

val QuartzParser.MultiplicativeOperationContext.ID: TwoArgOperatorNode.ID
    get() = when (text) {
        "*" -> TwoArgOperatorNode.ID.MULTIPLY
        "/" -> TwoArgOperatorNode.ID.DIVIDE
        "%" -> TwoArgOperatorNode.ID.MOD
        else -> throw Exception("Unrecognized multiplicative operator $text")
    }
