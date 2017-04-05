package quartz.compiler.builder

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.semantics.types.TemplateType
import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.FnDeclaration
import quartz.compiler.tree.function.Statement
import quartz.compiler.tree.function.expression.*
import quartz.compiler.tree.function.statement.*
import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.FnDeclarationContext.toNode(): GlobalDeclaration {
    return if (extern != null) {
        ExternFunctionDeclaration(
                identifier().text,
                Function(
                        typeList().type().map { it.toType() },
                        emptyList(),
                        returnType?.toType() ?: Primitives.void,
                        typeList().vararg != null
                )
        )
    } else {
        FnDeclaration(
                identifier().text,
                fnArgumentList().fnArgument().map { it.identifier().text },
                Function(
                        fnArgumentList().fnArgument().map { it.type().toType() },
                        identifierList()?.identifier()?.map { TemplateType(it.text) } ?: emptyList(),
                        returnType?.toType() ?: Primitives.void,
                        false
                ),
                if (body.expression() != null) {
                    listOf(ReturnStatement(body.expression().toNode()))
                } else {
                    body.block().statement().map { it.toNode() }
                }
        )
    }
}

fun QuartzParser.StatementContext.toNode(): Statement {
    return when {
        inlineC() != null -> inlineC().toNode()
        returnStatement() != null -> returnStatement().toNode()
        varDeclaration() != null -> varDeclaration().toNode()
        ifStatement() != null -> ifStatement().toNode()
        whileLoop() != null -> whileLoop().toNode()
        expression() != null -> expression().toNode()
        else -> throw QuartzException("Error translating $text")
    }
}

fun QuartzParser.ReturnStatementContext.toNode(): ReturnStatement {
    return ReturnStatement(expression().toNode())
}

fun QuartzParser.VarDeclarationContext.toNode(): VariableDeclaration {
    return VariableDeclaration(
            identifier().text,
            expression().toNode(),
            if (type() != null) type().toType() else null,
            varDeclarationType().text == "var"
    )
}

fun QuartzParser.IfStatementContext.toNode(): IfStatement {
    return IfStatement(
            expression().toNode(),
            trueBlock?.statement()?.map { it.toNode() } ?: listOf(),
            falseBlock?.statement()?.map { it.toNode() } ?: listOf()
    )
}

fun QuartzParser.WhileLoopContext.toNode(): WhileLoop {
    return WhileLoop(expression().toNode(), block().statement()?.map { it.toNode() } ?: listOf())
}

fun QuartzParser.ExpressionContext.toNode(): Expression {
    return disjunction().toNode()
}

fun QuartzParser.DisjunctionContext.toNode(): Expression {
    return when {
        disjunction() == null -> conjunction().toNode()
        else -> BinaryOperator(conjunction().toNode(), disjunction().toNode(), BinaryOperator.ID.OR, null)
    }
}

fun QuartzParser.ConjunctionContext.toNode(): Expression {
    return when {
        conjunction() == null -> equalityComparison().toNode()
        else -> BinaryOperator(equalityComparison().toNode(), conjunction().toNode(), BinaryOperator.ID.AND, null)
    }
}

fun QuartzParser.EqualityComparisonContext.toNode(): Expression {
    return when {
        equalityComparison() == null -> comparison().toNode()
        else -> BinaryOperator(comparison().toNode(), equalityComparison().toNode(), equalityOperation().ID, null)
    }
}

fun QuartzParser.ComparisonContext.toNode(): Expression {
    return when {
        comparison() == null -> additiveExpression().toNode()
        else -> BinaryOperator(additiveExpression().toNode(), comparison().toNode(), comparisonOperation().ID, null)
    }
}

fun QuartzParser.AdditiveExpressionContext.toNode(): Expression {
    return when {
        additiveExpression() == null -> multiplicativeExpression().toNode()
        else -> BinaryOperator(multiplicativeExpression().toNode(), additiveExpression().toNode(), additiveOperation().ID, null)
    }
}

fun QuartzParser.MultiplicativeExpressionContext.toNode(): Expression {
    return when {
        multiplicativeExpression() == null -> prefixExpression().toNode()
        else -> BinaryOperator(prefixExpression().toNode(), multiplicativeExpression().toNode(), multiplicativeOperation().ID, null)
    }
}

fun QuartzParser.PrefixExpressionContext.toNode(operations: List<QuartzParser.PrefixOperationContext>? = prefixOperation()): Expression {
    return when {
        operations == null || operations.isEmpty() -> postfixExpression().toNode()
        operations.size == 1 -> operations[0].toNode(postfixExpression().toNode())
        else -> operations.last().toNode(toNode(operations.dropLast(1)))
    }
}

fun QuartzParser.PrefixOperationContext.toNode(expression: Expression): Expression {
    return UnaryOperator(expression, when (text) {
        "-" -> UnaryOperator.ID.NEGATE
        "!" -> UnaryOperator.ID.INVERT
        else -> throw QuartzException("Unrecognized prefix operator $text")
    }, null)
}

fun QuartzParser.PostfixExpressionContext.toNode(operations: List<QuartzParser.PostfixOperationContext>? = postfixOperation()): Expression {
    return when {
        operations == null || operations.isEmpty() -> atomicExpression().toNode()
        operations.size == 1 -> operations[0].toNode(atomicExpression().toNode())
        else -> operations.last().toNode(toNode(operations.dropLast(1)))
    }
}

fun QuartzParser.PostfixOperationContext.toNode(expression: Expression): Expression {
    return when {
        arrayAccess() != null -> arrayAccess().toNode(expression)
        memberAccess() != null -> memberAccess().toNode(expression)
        postfixCall() != null -> postfixCall().toNode(expression)
        else -> throw QuartzException("Unrecognized postfix operation $text")
    }
}

fun QuartzParser.AtomicExpressionContext.toNode(): Expression {
    return when {
        expression() != null -> expression().toNode()
        ifExpression() != null -> ifExpression().toNode()
        identifier() != null -> identifier().toNode()
        inlineC() != null -> inlineC().toNode()
        literal() != null -> literal().toNode()
        else -> throw QuartzException("Unrecognized atomic expression $text")
    }
}

fun QuartzParser.ArrayAccessContext.toNode(expression: Expression): Expression {
    return BinaryOperator(expression, expression().toNode(), BinaryOperator.ID.ARRAY_ACCESS, null)
}

fun QuartzParser.MemberAccessContext.toNode(expression: Expression): MemberAccess {
    return MemberAccess(identifier().text, expression, null)
}

fun QuartzParser.PostfixCallContext.toNode(expression: Expression): FunctionCall {
    return FunctionCall(
            expression,
            typeList()?.type()?.map { it.toType() } ?: emptyList(),
            expressionList().expression().map { it.toNode() },
            null
    )
}

fun QuartzParser.IfExpressionContext.toNode(): IfExpression {
    return IfExpression(test.toNode(), ifTrue.toNode(), ifFalse.toNode(), null)
}

fun QuartzParser.IdentifierContext.toNode(): Identifier {
    return Identifier(text, null)
}

fun QuartzParser.LiteralContext.toNode(): Expression {
    return when {
        CHAR() != null -> NumberLiteral(text, Primitives.char)
        INT() != null -> NumberLiteral(text, Primitives.int)
        DOUBLE() != null -> NumberLiteral(text, Primitives.double)
        STRING() != null -> StringLiteral(text.substring(1, text.length-1))
        else -> throw QuartzException("Error translating $this")
    }
}

val QuartzParser.EqualityOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        "==" -> BinaryOperator.ID.EQUALS
        "!=" -> BinaryOperator.ID.NOT_EQUALS
        else -> throw QuartzException("Unrecognized equality operator $text")
    }

val QuartzParser.ComparisonOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        ">" -> BinaryOperator.ID.GREATER_THAN
        "<" -> BinaryOperator.ID.LESS_THAN
        ">=" -> BinaryOperator.ID.GREATER_THAN_OR_EQUALS
        "<=" -> BinaryOperator.ID.LESS_THAN_OR_EQUALS
        else -> throw QuartzException("Unrecognized comparison operator $text")
    }

val QuartzParser.AdditiveOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        "+" -> BinaryOperator.ID.ADD
        "-" -> BinaryOperator.ID.SUBTRACT
        else -> throw QuartzException("Unrecognized additive operator $text")
    }

val QuartzParser.MultiplicativeOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        "*" -> BinaryOperator.ID.MULTIPLY
        "/" -> BinaryOperator.ID.DIVIDE
        "%" -> BinaryOperator.ID.MOD
        else -> throw QuartzException("Unrecognized multiplicative operator $text")
    }
