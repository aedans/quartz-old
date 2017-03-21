package quartz.compiler.syntax.builder.program.function

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.program.function.expression.toNode
import quartz.compiler.syntax.builder.program.function.statements.toNode
import quartz.compiler.syntax.builder.program.misc.toNode
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.expression.BinaryOperatorNode
import quartz.compiler.syntax.tree.program.function.expression.UnaryOperatorNode

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
        BinaryOperatorNode(conjunction().toNode(), disjunction().toNode(), BinaryOperatorNode.ID.OR, null)
    }
}

fun QuartzParser.ConjunctionContext.toNode(): ExpressionNode {
    return if (conjunction() == null) {
        equalityComparison().toNode()
    } else {
        BinaryOperatorNode(equalityComparison().toNode(), conjunction().toNode(), BinaryOperatorNode.ID.AND, null)
    }
}

fun QuartzParser.EqualityComparisonContext.toNode(): ExpressionNode {
    return if (equalityComparison() == null) {
        comparison().toNode()
    } else {
        BinaryOperatorNode(comparison().toNode(), equalityComparison().toNode(), equalityOperation().ID, null)
    }
}

fun QuartzParser.ComparisonContext.toNode(): ExpressionNode {
    return when {
        comparison() == null -> additiveExpression().toNode()
        else -> BinaryOperatorNode(additiveExpression().toNode(), comparison().toNode(), comparisonOperation().ID, null)
    }
}

fun QuartzParser.AdditiveExpressionContext.toNode(): ExpressionNode {
    return when {
        additiveExpression() == null -> multiplicativeExpression().toNode()
        else -> BinaryOperatorNode(multiplicativeExpression().toNode(), additiveExpression().toNode(), additiveOperation().ID, null)
    }
}

fun QuartzParser.MultiplicativeExpressionContext.toNode(): ExpressionNode {
    return when {
        multiplicativeExpression() == null -> prefixExpression().toNode()
        else -> BinaryOperatorNode(prefixExpression().toNode(), multiplicativeExpression().toNode(), multiplicativeOperation().ID, null)
    }
}

fun QuartzParser.PrefixExpressionContext.toNode(operations: List<QuartzParser.PrefixOperationContext>? = prefixOperation()): ExpressionNode {
    return when {
        operations == null || operations.isEmpty() -> postfixExpression().toNode()
        operations.size == 1 -> operations[0].toNode(postfixExpression().toNode())
        else -> operations.last().toNode(toNode(operations.dropLast(1)))
    }
}

fun QuartzParser.PrefixOperationContext.toNode(expression: ExpressionNode): ExpressionNode {
    return UnaryOperatorNode(expression, when (text) {
        "-" -> UnaryOperatorNode.ID.NEGATE
        "!" -> UnaryOperatorNode.ID.INVERT
        else -> throw Exception("Unrecognized prefix operator $text")
    }, null)
}

fun QuartzParser.PostfixExpressionContext.toNode(operations: List<QuartzParser.PostfixOperationContext>? = postfixOperation()): ExpressionNode {
    return when {
        operations == null || operations.isEmpty() -> atomicExpression().toNode()
        operations.size == 1 -> operations[0].toNode(atomicExpression().toNode())
        else -> operations.last().toNode(toNode(operations.dropLast(1)))
    }
}

fun QuartzParser.PostfixOperationContext.toNode(expression: ExpressionNode): ExpressionNode {
    return when {
        arrayAccess() != null -> arrayAccess().toNode(expression)
        infixCall() != null -> infixCall().toNode(expression)
        memberAccess() != null -> memberAccess().toNode(expression)
        else -> throw Exception("Unrecognized postfix operation $text")
    }
}

fun QuartzParser.AtomicExpressionContext.toNode(): ExpressionNode {
    return when {
        expression() != null -> expression().toNode()
        ifExpression() != null -> ifExpression().toNode()
        prefixCallExpression() != null -> prefixCallExpression().toNode()
        identifier() != null -> identifier().toNode()
        inlineC() != null -> inlineC().toNode()
        literal() != null -> literal().toNode()
        else -> throw Exception("Unrecognized atomic expression $text")
    }
}

val QuartzParser.EqualityOperationContext.ID: BinaryOperatorNode.ID
    get() = when (text) {
        "==" -> BinaryOperatorNode.ID.EQUALS
        "!=" -> BinaryOperatorNode.ID.NOT_EQUALS
        else -> throw Exception("Unrecognized equality operator $text")
    }

val QuartzParser.ComparisonOperationContext.ID: BinaryOperatorNode.ID
    get() = when (text) {
        ">" -> BinaryOperatorNode.ID.GREATER_THAN
        "<" -> BinaryOperatorNode.ID.LESS_THAN
        ">=" -> BinaryOperatorNode.ID.GREATER_THAN_OR_EQUALS
        "<=" -> BinaryOperatorNode.ID.LESS_THAN_OR_EQUALS
        else -> throw Exception("Unrecognized comparison operator $text")
    }

val QuartzParser.AdditiveOperationContext.ID: BinaryOperatorNode.ID
    get() = when (text) {
        "+" -> BinaryOperatorNode.ID.ADD
        "-" -> BinaryOperatorNode.ID.SUBTRACT
        else -> throw Exception("Unrecognized additive operator $text")
    }

val QuartzParser.MultiplicativeOperationContext.ID: BinaryOperatorNode.ID
    get() = when (text) {
        "*" -> BinaryOperatorNode.ID.MULTIPLY
        "/" -> BinaryOperatorNode.ID.DIVIDE
        "%" -> BinaryOperatorNode.ID.MOD
        else -> throw Exception("Unrecognized multiplicative operator $text")
    }
