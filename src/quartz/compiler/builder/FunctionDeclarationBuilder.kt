package quartz.compiler.builder

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.CharType
import quartz.compiler.semantics.types.DoubleType
import quartz.compiler.semantics.types.IntType
import quartz.compiler.semantics.types.VoidType
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
                genericArgumentList()?.genericArgument()?.map { it.NAME().text } ?: emptyList(),
                Function(
                        fnArgumentList().fnArgument().map { it.type().toType() },
                        returnType?.toType() ?: VoidType,
                        false
                ),
                atomicBlock().toNode()
        )
    }
}

fun QuartzParser.ExpressionContext.toNode(): Expression {
    return errorScope({ "expression $text" }) {
        when {
            varDeclaration() != null -> varDeclaration().toNode()
            returnExpression() != null -> returnExpression().toNode()
            ifExpression() != null -> ifExpression().toNode()
            whileExpression() != null -> whileExpression().toNode()
            assignmentExpression() != null -> assignmentExpression().toNode()
            else -> throw Exception("Unrecognized expression $text")
        }
    }
}

fun QuartzParser.IfExpressionContext.toNode(): IfExpression {
    return IfExpression(test.toNode(), ifTrue.toNode(), ifFalse?.toNode() ?: BlockExpression(emptyList()), null)
}

fun QuartzParser.WhileExpressionContext.toNode(): WhileExpression {
    return WhileExpression(test.toNode(), block().toNode())
}

fun QuartzParser.AssignmentExpressionContext.toNode(): Expression {
    return when {
        assignmentExpression() == null -> disjunction().toNode()
        else -> Assignment(disjunction().toNode(), assignmentExpression().toNode(), assignmentOperation().ID, null)
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
        multiplicativeExpression() == null -> operableExpression().toNode()
        else -> BinaryOperator(operableExpression().toNode(), multiplicativeExpression().toNode(), multiplicativeOperation().ID, null)
    }
}

fun QuartzParser.OperableExpressionContext.toNode(): Expression {
    return when {
        prefixOperation() != null -> prefixOperation().toNode(operableExpression().toNode())
        postfixOperation() != null -> postfixOperation().toNode(operableExpression().toNode())
        atomicExpression() != null -> atomicExpression().toNode()
        else -> throw Exception("Unrecognized expression $text")
    }
}

fun QuartzParser.PrefixOperationContext.toNode(expression: Expression): Expression {
    return UnaryOperator(expression, ID, null)
}

fun QuartzParser.PostfixOperationContext.toNode(expression: Expression): Expression {
    return when {
        cast() != null -> cast().toNode(expression)
        memberAccess() != null -> memberAccess().toNode(expression)
        postfixCall() != null -> postfixCall().toNode(expression)
        dotCall() != null -> dotCall().toNode(expression)
        else -> throw Exception("Unrecognized postfix operation $text")
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
        identifier() != null -> identifier().toNode()
        lambda() != null -> lambda().toNode()
        else -> throw Exception("Unrecognized atomic expression $text")
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
    return Identifier(NAME().text, typeList()?.type()?.map { it.toType() } ?: emptyList(), null)
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
                atomicBlock().toNode()
        )
        else -> Lambda(
                nameList()?.NAME()?.map { it.text },
                Function(
                        null,
                        returnType?.toType(),
                        false
                ),
                atomicBlock().toNode()
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
            expressionList()?.expression()?.map { it.toNode() } ?: emptyList<Expression>(),
            null
    )
}

fun QuartzParser.DotCallContext.toNode(expression: Expression): FunctionCall {
    return FunctionCall(
            identifier().toNode(),
            listOf(expression) + (expressionList()?.expression()?.map { it.toNode() } ?: emptyList<Expression>()),
            null
    )
}

fun QuartzParser.VarDeclarationContext.toNode(): VariableDeclaration {
    return VariableDeclaration(
            NAME().text,
            expression()?.toNode(),
            if (type() != null) type().toType() else null,
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
