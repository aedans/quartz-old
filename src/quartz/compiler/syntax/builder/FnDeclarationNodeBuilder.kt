package quartz.compiler.syntax.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.function.StatementNode
import quartz.compiler.syntax.tree.function.expression.*
import quartz.compiler.syntax.tree.function.statement.*
import quartz.compiler.util.types.Primitives

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.FnDeclarationContext.toNode(): FnDeclarationNode {
    return FnDeclarationNode(
            name.text,
            fnArgumentList()?.fnArgument()?.map { it.name.text to it.type.toType() } ?: listOf(),
            returnType?.toType() ?: Primitives.void,
            if (body.expression() != null) {
                listOf(ReturnNode(body.expression().toNode()))
            } else {
                body.block().statement().map { it.toNode() }
            }
    )
}

fun QuartzParser.StatementContext.toNode(): StatementNode {
    return when {
        inlineC() != null -> inlineC().toNode()
        returnStatement() != null -> returnStatement().toNode()
        varDeclaration() != null -> varDeclaration().toNode()
        ifStatement() != null -> ifStatement().toNode()
        whileLoop() != null -> whileLoop().toNode()
        prefixCallExpression() != null -> prefixCallExpression().toNode()
        infixCallExpression() != null -> infixCallExpression().toNode()
        else -> throw Exception("Error translating $text")
    }
}

fun QuartzParser.ReturnStatementContext.toNode(): ReturnNode {
    return ReturnNode(expression().toNode())
}

fun QuartzParser.VarDeclarationContext.toNode(): VarDeclarationNode {
    return VarDeclarationNode(
            name.text,
            if (type != null) type.toType() else null,
            declarationType.text == "var",
            value.toNode()
    )
}

fun QuartzParser.IfStatementContext.toNode(): IfStatementNode {
    return IfStatementNode(
            expression().toNode(),
            trueBlock?.statement()?.map { it.toNode() } ?: listOf(),
            falseBlock?.statement()?.map { it.toNode() } ?: listOf()
    )
}

fun QuartzParser.WhileLoopContext.toNode(): WhileLoopNode {
    return WhileLoopNode(expression().toNode(), block().statement()?.map { it.toNode() } ?: listOf())
}
fun QuartzParser.PrefixCallExpressionContext.toNode(): FnCallNode {
    return FnCallNode(
            identifier().text,
            expressionList().expression().map { it.toNode() }.toMutableList(),
            null
    )
}

// TODO: Shorten by getting IntelliJ to understand what packages are
fun QuartzParser.InfixCallExpressionContext.toNode(): FnCallNode {
    val args = infixCall().expressionList().expression().map { it.toNode() }.toMutableList()
    args.add(0, expression().toNode())
    return FnCallNode(
            infixCall().identifier().text,
            args,
            null
    )
}

fun QuartzParser.InfixCallContext.toNode(expression: ExpressionNode): FnCallNode {
    val args = expressionList().expression().map { it.toNode() }.toMutableList()
    args.add(0, expression)
    return FnCallNode(
            identifier().text,
            args,
            null
    )
}
fun QuartzParser.ExpressionContext.toNode(): ExpressionNode {
    return disjunction().toNode()
}

fun QuartzParser.DisjunctionContext.toNode(): ExpressionNode {
    return when {
        disjunction() == null -> conjunction().toNode()
        else -> BinaryOperatorNode(conjunction().toNode(), disjunction().toNode(), BinaryOperatorNode.ID.OR, null)
    }
}

fun QuartzParser.ConjunctionContext.toNode(): ExpressionNode {
    return when {
        conjunction() == null -> equalityComparison().toNode()
        else -> BinaryOperatorNode(equalityComparison().toNode(), conjunction().toNode(), BinaryOperatorNode.ID.AND, null)
    }
}

fun QuartzParser.EqualityComparisonContext.toNode(): ExpressionNode {
    return when {
        equalityComparison() == null -> comparison().toNode()
        else -> BinaryOperatorNode(comparison().toNode(), equalityComparison().toNode(), equalityOperation().ID, null)
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

fun QuartzParser.MemberAccessContext.toNode(expression: ExpressionNode): MemberAccessNode {
    return MemberAccessNode(identifier().text, null, expression)
}

fun QuartzParser.ArrayAccessContext.toNode(expression: ExpressionNode): ExpressionNode {
    return BinaryOperatorNode(expression, expression().toNode(), BinaryOperatorNode.ID.ARRAY_ACCESS, null)
}

fun QuartzParser.IfExpressionContext.toNode(): IfExpressionNode {
    return IfExpressionNode(test.toNode(), ifTrue.toNode(), ifFalse.toNode(), null)
}

fun QuartzParser.IdentifierContext.toNode(): IdentifierNode {
    return IdentifierNode(text, null)
}

fun QuartzParser.LiteralContext.toNode(): ExpressionNode {
    return when {
        CHAR() != null -> NumberLiteralNode(text, Primitives.char)
        INT() != null -> NumberLiteralNode(text, Primitives.int)
        DOUBLE() != null -> NumberLiteralNode(text, Primitives.double)
        STRING() != null -> StringLiteralNode(text.substring(1, text.length-1))
        else -> throw Exception("Error translating $this")
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