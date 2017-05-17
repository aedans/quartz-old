package quartz.compiler.builder

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.*
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.*
import quartz.compiler.tree.util.Function

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.FunctionDeclarationContext.toNode(): FunctionDeclaration {
    return errorScope({ "function ${NAME()?.text}" }) {
        FunctionDeclaration(
                NAME().text,
                fnArgumentList().fnArgument().map { it.NAME().text },
                Function(
                        fnArgumentList().fnArgument().map { it.type().toType() },
                        returnType?.toType() ?: VoidType,
                        false
                ),
                eBlock().toNode()
        )
    }
}

fun QuartzParser.ExpressionContext.toNode(): Expression {
    return errorScope({ "expression $text" }) {
        when {
            expression() == null -> disjunction().toNode()
            else -> Assignment(disjunction().toNode(), expression().toNode(), assignmentOperation().ID, null)
        }
    }
}

fun QuartzParser.DisjunctionContext.toNode(): Expression {
    return when {
        disjunction() == null -> conjunction().toNode()
        else -> BinaryOperator(conjunction().toNode(), disjunction().toNode(), disjunctionOperation().ID, null)
    }
}

fun QuartzParser.ConjunctionContext.toNode(): Expression {
    return when {
        conjunction() == null -> equalityComparison().toNode()
        else -> BinaryOperator(equalityComparison().toNode(), conjunction().toNode(), conjunctionOperation().ID, null)
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
        comparison() == null -> bitshiftExpression().toNode()
        else -> BinaryOperator(bitshiftExpression().toNode(), comparison().toNode(), comparisonOperation().ID, null)
    }
}

fun QuartzParser.BitshiftExpressionContext.toNode(): Expression {
    return when {
        bitshiftExpression() == null -> additiveExpression().toNode()
        else -> BinaryOperator(additiveExpression().toNode(), bitshiftExpression().toNode(), bitshiftOperation().ID, null)
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
    return PrefixUnaryOperator(expression, ID, null)
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
        cast() != null -> cast().toNode(expression)
        memberAccess() != null -> memberAccess().toNode(expression)
        postfixCall() != null -> postfixCall().toNode(expression)
        dotCall() != null -> dotCall().toNode(expression)
        else -> PostfixUnaryOperator(expression, ID, null)
    }
}

fun QuartzParser.AtomicExpressionContext.toNode(): Expression {
    return when {
        expression() != null -> expression().toNode()
        inlineC() != null -> inlineC().toNode()
        literal() != null -> literal().toNode()
        sizeof() != null -> sizeof().toNode()
        breakExpression() != null -> breakExpression().toNode()
        continueExpression() != null -> continueExpression().toNode()
        returnExpression() != null -> returnExpression().toNode()
        identifier() != null -> identifier().toNode()
        ifExpression() != null -> ifExpression().toNode()
        whileExpression() != null -> whileExpression().toNode()
        varDeclaration() != null -> varDeclaration().toNode()
        lambda() != null -> lambda().toNode()
        else -> throw QuartzException("Unrecognized atomic expression $text")
    }
}

fun QuartzParser.LiteralContext.toNode(): Expression {
    return when {
        CHAR() != null -> NumberLiteral(text, CharType)
        INT() != null -> NumberLiteral(text, IntType)
        DOUBLE() != null -> NumberLiteral(text, DoubleType)
        STRING() != null -> StringLiteral(text.substring(1, text.length-1))
        else -> throw QuartzException("Error translating $this")
    }
}

fun QuartzParser.SizeofContext.toNode(): Sizeof {
    return Sizeof(type().toType())
}

@Suppress("unused")
fun QuartzParser.BreakExpressionContext.toNode(): Break {
    return Break
}

@Suppress("unused")
fun QuartzParser.ContinueExpressionContext.toNode(): Continue {
    return Continue
}

fun QuartzParser.ReturnExpressionContext.toNode(): ReturnExpression {
    return ReturnExpression(expression().toNode())
}

fun QuartzParser.IdentifierContext.toNode(): Identifier {
    return Identifier(NAME().text, null)
}

fun QuartzParser.IfExpressionContext.toNode(): IfExpression {
    return IfExpression(test.toNode(), ifTrue.toNode(), ifFalse?.toNode() ?: BlockExpression(emptyList()), null)
}

fun QuartzParser.WhileExpressionContext.toNode(): WhileExpression {
    return WhileExpression(test.toNode(), loop.toNode())
}

fun QuartzParser.LambdaContext.toNode(): Lambda {
    return when {
        fnArgumentList() != null -> Lambda(
                fnArgumentList().fnArgument().map { it.NAME().text },
                Function(
                        fnArgumentList().fnArgument().map { it.type().toType() },
                        returnType?.toType(),
                        false
                ),
                eBlock().toNode()
        )
        else -> Lambda(
                nameList()?.NAME()?.map { it.text },
                Function(
                        null,
                        returnType?.toType(),
                        false
                ),
                eBlock().toNode()
        )
    }
}

fun QuartzParser.CastContext.toNode(expression: Expression): Cast {
    return Cast(expression, type().toType())
}

fun QuartzParser.MemberAccessContext.toNode(expression: Expression): MemberAccess {
    return MemberAccess(NAME().text, expression, null)
}

fun QuartzParser.PostfixCallContext.toNode(expression: Expression): FunctionCall {
    return FunctionCall(
            expression,
            expressionList()?.expression()?.map { it.toNode() } ?: emptyList<Expression>()
                    .let { if (lambda() != null) it + lambda().toNode() else it },
            null
    )
}

fun QuartzParser.DotCallContext.toNode(expression: Expression): FunctionCall {
    return FunctionCall(
            identifier().toNode(),
            (listOf(expression) + (expressionList()?.expression()?.map { it.toNode() } ?: emptyList<Expression>()))
                    .let { if (lambda() != null) it + lambda().toNode() else it },
            null
    )
}

fun QuartzParser.VarDeclarationContext.toNode(): VariableDeclaration {
    return VariableDeclaration(
            nameOptionalType().NAME().text,
            expression()?.toNode(),
            if (nameOptionalType()?.type() != null) nameOptionalType().type().toType() else null,
            varDeclarationType().text == "var"
    )
}

val QuartzParser.AssignmentOperationContext.ID: Assignment.ID
    get() = when (text) {
        "=" -> Assignment.ID.EQ
        "+=" -> Assignment.ID.PLUS_EQ
        "-=" -> Assignment.ID.MINUS_EQ
        "*=" -> Assignment.ID.TIMES_EQ
        "/=" -> Assignment.ID.DIV_EQ
        "%=" -> Assignment.ID.MOD_EQ
        "&=" -> Assignment.ID.BAND_EQ
        "|=" -> Assignment.ID.BOR_EQ
        "^=" -> Assignment.ID.BXOR_EQ
        "<<=" -> Assignment.ID.SHL_EQ
        ">>=" -> Assignment.ID.SHR_EQ
        else -> throw QuartzException("Unrecognized assignment operation $text")
    }

val QuartzParser.DisjunctionOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        "||" -> BinaryOperator.ID.OR
        "|" -> BinaryOperator.ID.BOR
        "^" -> BinaryOperator.ID.BXOR
        else -> throw QuartzException("Unrecognized disjunction $text")
    }

val QuartzParser.ConjunctionOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        "&&" -> BinaryOperator.ID.AND
        "&" -> BinaryOperator.ID.BAND
        else -> throw QuartzException("Unrecognized conjunction $text")
    }

val QuartzParser.EqualityOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        "==" -> BinaryOperator.ID.EQ
        "!=" -> BinaryOperator.ID.NEQ
        else -> throw QuartzException("Unrecognized equality operation $text")
    }

val QuartzParser.ComparisonOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        ">" -> BinaryOperator.ID.GT
        "<" -> BinaryOperator.ID.LT
        ">=" -> BinaryOperator.ID.GEQ
        "<=" -> BinaryOperator.ID.LEQ
        else -> throw QuartzException("Unrecognized comparison operation $text")
    }

val QuartzParser.BitshiftOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        ">>" -> BinaryOperator.ID.SHR
        "<<" -> BinaryOperator.ID.SHL
        else -> throw QuartzException("Unrecognized bitshift operation $text")
    }

val QuartzParser.AdditiveOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        "+" -> BinaryOperator.ID.ADD
        "-" -> BinaryOperator.ID.SUBT
        else -> throw QuartzException("Unrecognized additive operation $text")
    }

val QuartzParser.MultiplicativeOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        "*" -> BinaryOperator.ID.MULT
        "/" -> BinaryOperator.ID.DIV
        "%" -> BinaryOperator.ID.MOD
        else -> throw QuartzException("Unrecognized multiplicative operation $text")
    }

val QuartzParser.PrefixOperationContext.ID: PrefixUnaryOperator.ID
    get() = when (text) {
        "++" -> PrefixUnaryOperator.ID.INCREMENT
        "--" -> PrefixUnaryOperator.ID.DECREMENT
        "+" -> PrefixUnaryOperator.ID.PLUS
        "-" -> PrefixUnaryOperator.ID.MINUS
        "!" -> PrefixUnaryOperator.ID.NOT
        "~" -> PrefixUnaryOperator.ID.BNOT
        else -> throw QuartzException("Unrecognized prefix operation $text")
    }

val QuartzParser.PostfixOperationContext.ID: PostfixUnaryOperator.ID
    get() = when (text) {
        "++" -> PostfixUnaryOperator.ID.INCREMENT
        "--" -> PostfixUnaryOperator.ID.DECREMENT
        else -> throw QuartzException("Unrecognized postfix operation $text")
    }
