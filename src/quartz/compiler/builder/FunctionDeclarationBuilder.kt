package quartz.compiler.builder

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.CharType
import quartz.compiler.semantics.types.DoubleType
import quartz.compiler.semantics.types.IntType
import quartz.compiler.semantics.types.VoidType
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.*
import quartz.compiler.tree.util.Function

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.FunctionDeclarationContext.toExpr(): FunctionDeclaration {
    return errorScope({ "function ${NAME()?.text}" }) {
        val nameTypeList = nameTypeList().toList()
        FunctionDeclaration(
                NAME().text,
                nameTypeList.map { it.first },
                Function(
                        nameTypeList.map { it.second },
                        returnType?.toType() ?: VoidType,
                        false
                ),
                atomicBlock().toExpr()
        )
    }
}

fun QuartzParser.ExpressionContext.toExpr(): Expression {
    return errorScope({ "expression $text" }) {
        when {
            varDeclaration() != null -> varDeclaration().toExpr()
            ifExpression() != null -> ifExpression().toExpr()
            assignmentExpression() != null -> assignmentExpression().toExpr()
            else -> throw Exception("Unrecognized expression $text")
        }
    }
}

fun QuartzParser.IfExpressionContext.toExpr(): IfExpression {
    return IfExpression(test.toExpr(), ifTrue.toExpr(), ifFalse?.toExpr() ?: Block(emptyList()), null)
}

fun QuartzParser.AssignmentExpressionContext.toExpr(): Expression {
    return when {
        assignmentExpression() == null -> disjunction().toExpr()
        else -> when (assignmentOperation().text) {
            "=" -> Assignment(disjunction().toExpr(), assignmentExpression().toExpr(), null)
            else -> Assignment(
                    disjunction().toExpr(),
                    BinaryOperator(
                            disjunction().toExpr(),
                            assignmentExpression().toExpr(),
                            assignmentOperation().ID,
                            null
                    ),
                    null
            )
        }
    }
}

fun QuartzParser.DisjunctionContext.toExpr(): Expression {
    return when {
        disjunction() == null -> conjunction().toExpr()
        else -> BinaryOperator(conjunction().toExpr(), disjunction().toExpr(), disjunctionOperation().ID, null)
    }
}

fun QuartzParser.ConjunctionContext.toExpr(): Expression {
    return when {
        conjunction() == null -> equalityComparison().toExpr()
        else -> BinaryOperator(equalityComparison().toExpr(), conjunction().toExpr(), conjunctionOperation().ID, null)
    }
}

fun QuartzParser.EqualityComparisonContext.toExpr(): Expression {
    return when {
        equalityComparison() == null -> comparison().toExpr()
        else -> BinaryOperator(comparison().toExpr(), equalityComparison().toExpr(), equalityOperation().ID, null)
    }
}

fun QuartzParser.ComparisonContext.toExpr(): Expression {
    return when {
        comparison() == null -> bitshiftExpression().toExpr()
        else -> BinaryOperator(bitshiftExpression().toExpr(), comparison().toExpr(), comparisonOperation().ID, null)
    }
}

fun QuartzParser.BitshiftExpressionContext.toExpr(): Expression {
    return when {
        bitshiftExpression() == null -> additiveExpression().toExpr()
        else -> BinaryOperator(additiveExpression().toExpr(), bitshiftExpression().toExpr(), bitshiftOperation().ID, null)
    }
}

fun QuartzParser.AdditiveExpressionContext.toExpr(): Expression {
    return when {
        additiveExpression() == null -> multiplicativeExpression().toExpr()
        else -> BinaryOperator(multiplicativeExpression().toExpr(), additiveExpression().toExpr(), additiveOperation().ID, null)
    }
}

fun QuartzParser.MultiplicativeExpressionContext.toExpr(): Expression {
    return when {
        multiplicativeExpression() == null -> operableExpression().toExpr()
        else -> BinaryOperator(operableExpression().toExpr(), multiplicativeExpression().toExpr(), multiplicativeOperation().ID, null)
    }
}

fun QuartzParser.OperableExpressionContext.toExpr(): Expression {
    return when {
        prefixOperation() != null -> prefixOperation().toExpr(operableExpression().toExpr())
        postfixOperation() != null -> postfixOperation().toExpr(operableExpression().toExpr())
        atomicExpression() != null -> atomicExpression().toExpr()
        else -> throw Exception("Unrecognized expression $text")
    }
}

fun QuartzParser.PrefixOperationContext.toExpr(expression: Expression): Expression {
    return UnaryOperator(expression, ID, null)
}

fun QuartzParser.PostfixOperationContext.toExpr(expression: Expression): Expression {
    return when {
        cast() != null -> cast().toExpr(expression)
        postfixCall() != null -> postfixCall().toExpr(expression)
        dotCall() != null -> dotCall().toExpr(expression)
        else -> throw Exception("Unrecognized postfix operation $text")
    }
}

fun QuartzParser.AtomicExpressionContext.toExpr(): Expression {
    return when {
        expression() != null -> expression().toExpr()
        inlineC() != null -> inlineC().toExpr()
        literal() != null -> literal().toExpr()
        sizeof() != null -> sizeof().toExpr()
        identifier() != null -> identifier().toExpr()
        else -> throw Exception("Unrecognized atomic expression $text")
    }
}

fun QuartzParser.LiteralContext.toExpr(): Expression {
    return when {
        CHAR() != null -> NumberLiteral(text, CharType)
        INT() != null -> NumberLiteral(text, IntType)
        DOUBLE() != null -> NumberLiteral(text, DoubleType)
        STRING() != null -> StringLiteral(text.substring(1, text.length-1))
        else -> throw QuartzException("Error translating $this")
    }
}

fun QuartzParser.SizeofContext.toExpr(): Sizeof {
    return Sizeof(type().toType())
}

fun QuartzParser.IdentifierContext.toExpr(): Identifier {
    return Identifier(NAME().text, null)
}

fun QuartzParser.CastContext.toExpr(expression: Expression): Cast {
    return Cast(expression, type().toType())
}

fun QuartzParser.PostfixCallContext.toExpr(expression: Expression): FunctionCall {
    return FunctionCall(
            expression,
            expressionList().toList(),
            null
    )
}

fun QuartzParser.DotCallContext.toExpr(expression: Expression): FunctionCall {
    return FunctionCall(
            identifier().toExpr(),
            listOf(expression) + (expressionList().toList()),
            null
    )
}

fun QuartzParser.VarDeclarationContext.toExpr(): VariableDeclaration {
    return when {
        nameType() != null -> VariableDeclaration(
                nameType().NAME().text,
                expression()?.toExpr(),
                nameType().type().toType()
        )
        else -> VariableDeclaration(
                nameOptionalType().NAME().text,
                expression().toExpr(),
                nameOptionalType()?.type()?.toType()
        )
    }
}

val QuartzParser.AssignmentOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        "+=" -> BinaryOperator.ID.ADD
        "-=" -> BinaryOperator.ID.SUBT
        "*=" -> BinaryOperator.ID.MULT
        "/=" -> BinaryOperator.ID.DIV
        "%=" -> BinaryOperator.ID.MOD
        "&=" -> BinaryOperator.ID.BAND
        "|=" -> BinaryOperator.ID.BOR
        "^=" -> BinaryOperator.ID.BXOR
        "<<=" -> BinaryOperator.ID.SHL
        ">>=" -> BinaryOperator.ID.SHR
        else -> throw Exception("Unrecognized assignment operation $text")
    }

val QuartzParser.DisjunctionOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        "||" -> BinaryOperator.ID.OR
        "|" -> BinaryOperator.ID.BOR
        "^" -> BinaryOperator.ID.BXOR
        else -> throw Exception("Unrecognized disjunction $text")
    }

val QuartzParser.ConjunctionOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        "&&" -> BinaryOperator.ID.AND
        "&" -> BinaryOperator.ID.BAND
        else -> throw Exception("Unrecognized conjunction $text")
    }

val QuartzParser.EqualityOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        "==" -> BinaryOperator.ID.EQ
        "!=" -> BinaryOperator.ID.NEQ
        else -> throw Exception("Unrecognized equality operation $text")
    }

val QuartzParser.ComparisonOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        ">" -> BinaryOperator.ID.GT
        "<" -> BinaryOperator.ID.LT
        ">=" -> BinaryOperator.ID.GEQ
        "<=" -> BinaryOperator.ID.LEQ
        else -> throw Exception("Unrecognized comparison operation $text")
    }

val QuartzParser.BitshiftOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        ">>" -> BinaryOperator.ID.SHR
        "<<" -> BinaryOperator.ID.SHL
        else -> throw Exception("Unrecognized bitshift operation $text")
    }

val QuartzParser.AdditiveOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        "+" -> BinaryOperator.ID.ADD
        "-" -> BinaryOperator.ID.SUBT
        else -> throw Exception("Unrecognized additive operation $text")
    }

val QuartzParser.MultiplicativeOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        "*" -> BinaryOperator.ID.MULT
        "/" -> BinaryOperator.ID.DIV
        "%" -> BinaryOperator.ID.MOD
        else -> throw Exception("Unrecognized multiplicative operation $text")
    }

val QuartzParser.PrefixOperationContext.ID: UnaryOperator.ID
    get() = when (text) {
        "+" -> UnaryOperator.ID.PLUS
        "-" -> UnaryOperator.ID.MINUS
        "!" -> UnaryOperator.ID.NOT
        "~" -> UnaryOperator.ID.BNOT
        else -> throw Exception("Unrecognized prefix operation $text")
    }
