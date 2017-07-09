package quartz.compiler.builder

import quartz.compiler.errors.err
import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.CharType
import quartz.compiler.semantics.types.DoubleType
import quartz.compiler.semantics.types.IntType
import quartz.compiler.semantics.types.VoidType
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.*
import quartz.compiler.util.lValueOrError

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.FunctionDeclarationContext.toDecl(): FunctionDeclaration {
    return errorScope({ "function ${NAME()?.text}" }) {
        val nameTypeList = nameTypeList().toList()
        FunctionDeclaration(
                NAME().text,
                nameTypeList,
                returnType?.toType() ?: VoidType,
                expression().toExpr()
        )
    }
}

fun QuartzParser.ExpressionContext.toExpr(): Expression {
    return errorScope({ "expression $text" }) {
        when {
            letExpression() != null -> letExpression().toExpr()
            else -> disjunction().toExpr()
        }
    }
}

fun QuartzParser.DisjunctionContext.toExpr(): Expression {
    return when {
        disjunction() != null -> BinaryOperation(
                conjunction().toExpr(),
                disjunction().toExpr(),
                disjunctionOperation().ID
        )
        else ->  conjunction().toExpr()
    }
}

fun QuartzParser.ConjunctionContext.toExpr(): Expression {
    return when {
        conjunction() != null -> BinaryOperation(
                equalityComparison().toExpr(),
                conjunction().toExpr(),
                conjunctionOperation().ID
        )
        else -> equalityComparison().toExpr()
    }
}

fun QuartzParser.EqualityComparisonContext.toExpr(): Expression {
    return when {
        equalityComparison() != null -> BinaryOperation(
                comparison().toExpr(),
                equalityComparison().toExpr(),
                equalityOperation().ID
        )
        else -> comparison().toExpr()
    }
}

fun QuartzParser.ComparisonContext.toExpr(): Expression {
    return when {
        comparison() != null -> BinaryOperation(
                delegateExpression().toExpr(),
                comparison().toExpr(),
                comparisonOperation().ID
        )
        else -> delegateExpression().toExpr()
    }
}

fun QuartzParser.DelegateExpressionContext.toExpr(): Expression {
    return when {
        delegateExpression() != null -> ExpressionPair(statementExpression().toExpr(), delegateExpression().toExpr())
        else -> statementExpression().toExpr()
    }
}

fun QuartzParser.StatementExpressionContext.toExpr(): Expression {
    return when {
        ifExpression() != null -> ifExpression().toExpr()
        else -> assignmentExpression().toExpr()
    }
}

fun QuartzParser.AssignmentExpressionContext.toExpr(): Expression {
    return when {
        assignmentExpression() != null -> when (assignmentOperation().text) {
            "=" -> Assignment(bitshiftExpression().toExpr().lValueOrError(), assignmentExpression().toExpr())
            else -> Assignment(
                    bitshiftExpression().toExpr().lValueOrError(),
                    BinaryOperation(
                            bitshiftExpression().toExpr(),
                            assignmentExpression().toExpr(),
                            assignmentOperation().ID
                    )
            )
        }
        else -> bitshiftExpression().toExpr()
    }
}

fun QuartzParser.BitshiftExpressionContext.toExpr(): Expression {
    return when {
        bitshiftExpression() != null -> BinaryOperation(
                additiveExpression().toExpr(),
                bitshiftExpression().toExpr(),
                bitshiftOperation().ID
        )
        else ->  additiveExpression().toExpr()
    }
}

fun QuartzParser.AdditiveExpressionContext.toExpr(): Expression {
    return when {
        additiveExpression() != null -> BinaryOperation(
                multiplicativeExpression().toExpr(),
                additiveExpression().toExpr(),
                additiveOperation().ID
        )
        else -> multiplicativeExpression().toExpr()
    }
}

fun QuartzParser.MultiplicativeExpressionContext.toExpr(): Expression {
    return when {
        multiplicativeExpression() != null -> BinaryOperation(
                operableExpression().toExpr(),
                multiplicativeExpression().toExpr(),
                multiplicativeOperation().ID
        )
        else -> operableExpression().toExpr()
    }
}

fun QuartzParser.OperableExpressionContext.toExpr(): Expression {
    return when {
        prefixOperation() != null -> prefixOperation().toExpr(operableExpression().toExpr())
        postfixOperation() != null -> postfixOperation().toExpr(operableExpression().toExpr())
        else -> atomicExpression().toExpr()
    }
}

fun QuartzParser.PrefixOperationContext.toExpr(expression: Expression): Expression {
    return UnaryOperation(expression, ID)
}

fun QuartzParser.PostfixOperationContext.toExpr(expression: Expression): Expression {
    return when {
        cast() != null -> cast().toExpr(expression)
        postfixCall() != null -> postfixCall().toExpr(expression)
        dotCall() != null -> dotCall().toExpr(expression)
        else -> err { "Unrecognized postfix operation $text" }
    }
}

fun QuartzParser.AtomicExpressionContext.toExpr(): Expression {
    return when {
        expression() != null -> expression().toExpr()
        inlineC() != null -> inlineC().toExpr()
        literal() != null -> literal().toExpr()
        sizeof() != null -> sizeof().toExpr()
        identifier() != null -> identifier().toExpr()
        else -> err { "Unrecognized atomic expression $text" }
    }
}

fun QuartzParser.LiteralContext.toExpr(): Expression {
    return when {
        CHAR() != null -> NumberLiteral(text, CharType)
        INT() != null -> NumberLiteral(text, IntType)
        DOUBLE() != null -> NumberLiteral(text, DoubleType)
        STRING() != null -> StringLiteral(text.substring(1, text.length-1))
        else -> err { "Error translating $this" }
    }
}

fun QuartzParser.SizeofContext.toExpr(): Sizeof {
    return Sizeof(type().toType())
}

fun QuartzParser.IdentifierContext.toExpr(): Identifier {
    return Identifier(NAME().text, null)
}

fun QuartzParser.IfExpressionContext.toExpr(): IfExpression {
    return if (ifFalse == null)
        IfExpression(condition.toExpr(), ifTrue1.toExpr(), null)
    else
        IfExpression(condition.toExpr(), ifTrue2.toExpr(), ifFalse.toExpr())
}

fun QuartzParser.CastContext.toExpr(expression: Expression): Cast {
    return Cast(expression, type().toType())
}

fun QuartzParser.PostfixCallContext.toExpr(expression: Expression): FunctionCall {
    return FunctionCall(
            expression,
            atomicExpression().map { it.toExpr() },
            null
    )
}

fun QuartzParser.DotCallContext.toExpr(expression: Expression): FunctionCall {
    return FunctionCall(
            identifier().toExpr(),
            listOf(expression) + postfixCall().atomicExpression().map { it.toExpr() },
            null
    )
}

fun QuartzParser.LetExpressionContext.toExpr(): LetExpression {
    return when {
        nameType() != null -> LetExpression(
                nameType().NAME().text,
                value?.toExpr(),
                nameType().type().toType(),
                expr.toExpr()
        )
        else -> LetExpression(
                nameOptionalType().NAME().text,
                value.toExpr(),
                nameOptionalType()?.type()?.toType(),
                expr.toExpr()
        )
    }
}

val QuartzParser.AssignmentOperationContext.ID: BinaryOperation.ID
    get() = when (text) {
        "+=" -> BinaryOperation.ID.ADD
        "-=" -> BinaryOperation.ID.SUBT
        "*=" -> BinaryOperation.ID.MULT
        "/=" -> BinaryOperation.ID.DIV
        "%=" -> BinaryOperation.ID.MOD
        "&=" -> BinaryOperation.ID.BAND
        "|=" -> BinaryOperation.ID.BOR
        "^=" -> BinaryOperation.ID.BXOR
        "<<=" -> BinaryOperation.ID.SHL
        ">>=" -> BinaryOperation.ID.SHR
        else -> err { "Unrecognized assignment operation $text" }
    }

val QuartzParser.DisjunctionOperationContext.ID: BinaryOperation.ID
    get() = when (text) {
        "||" -> BinaryOperation.ID.OR
        "|" -> BinaryOperation.ID.BOR
        "^" -> BinaryOperation.ID.BXOR
        else -> err { "Unrecognized disjunction $text" }
    }

val QuartzParser.ConjunctionOperationContext.ID: BinaryOperation.ID
    get() = when (text) {
        "&&" -> BinaryOperation.ID.AND
        "&" -> BinaryOperation.ID.BAND
        else -> err { "Unrecognized conjunction $text" }
    }

val QuartzParser.EqualityOperationContext.ID: BinaryOperation.ID
    get() = when (text) {
        "==" -> BinaryOperation.ID.EQ
        "!=" -> BinaryOperation.ID.NEQ
        else -> err { "Unrecognized equality operation $text" }
    }

val QuartzParser.ComparisonOperationContext.ID: BinaryOperation.ID
    get() = when (text) {
        ">" -> BinaryOperation.ID.GT
        "<" -> BinaryOperation.ID.LT
        ">=" -> BinaryOperation.ID.GEQ
        "<=" -> BinaryOperation.ID.LEQ
        else -> err { "Unrecognized comparison operation $text" }
    }

val QuartzParser.BitshiftOperationContext.ID: BinaryOperation.ID
    get() = when (text) {
        ">>" -> BinaryOperation.ID.SHR
        "<<" -> BinaryOperation.ID.SHL
        else -> err { "Unrecognized bitshift operation $text" }
    }

val QuartzParser.AdditiveOperationContext.ID: BinaryOperation.ID
    get() = when (text) {
        "+" -> BinaryOperation.ID.ADD
        "-" -> BinaryOperation.ID.SUBT
        else -> err { "Unrecognized additive operation $text" }
    }

val QuartzParser.MultiplicativeOperationContext.ID: BinaryOperation.ID
    get() = when (text) {
        "*" -> BinaryOperation.ID.MULT
        "/" -> BinaryOperation.ID.DIV
        "%" -> BinaryOperation.ID.MOD
        else -> err { "Unrecognized multiplicative operation $text" }
    }

val QuartzParser.PrefixOperationContext.ID: UnaryOperation.ID
    get() = when (text) {
        "-" -> UnaryOperation.ID.MINUS
        "!" -> UnaryOperation.ID.NOT
        "~" -> UnaryOperation.ID.BNOT
        else -> err { "Unrecognized prefix operation $text" }
    }
