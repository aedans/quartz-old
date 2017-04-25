package quartz.compiler.builder

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.semantics.types.TemplateType
import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.Statement
import quartz.compiler.tree.function.expression.*
import quartz.compiler.tree.function.statement.*
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.FunctionDeclarationContext.toNode(): GlobalDeclaration {
    return errorScope({ "function ${identifier()?.text}" }) {
        FunctionDeclaration(
                identifier().text,
                fnArgumentList().fnArgument().map { it.identifier().text },
                Function(
                        fnArgumentList().fnArgument().map { it.type().toType() },
                        returnType?.toType() ?: Primitives.void,
                        identifierList()?.identifier()?.map { TemplateType(it.text) } ?: emptyList(),
                        false
                ),
                fnBlock().toNode()
        )
    }
}

fun QuartzParser.StatementContext.toNode(): Statement {
    return errorScope({ "statement $text" }) {
        when {
            inlineC() != null -> inlineC().toNode()
            returnStatement() != null -> returnStatement().toNode()
            varDeclaration() != null -> varDeclaration().toNode()
            ifStatement() != null -> ifStatement().toNode()
            whileLoop() != null -> whileLoop().toNode()
            expression() != null -> expression().toNode()
            else -> throw QuartzException("Error translating $text")
        }
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
            trueBlock?.toNode() ?: Block(emptyList()),
            falseBlock?.toNode() ?: Block(emptyList())
    )
}

fun QuartzParser.WhileLoopContext.toNode(): WhileLoop {
    return WhileLoop(expression().toNode(), block()?.toNode() ?: Block(emptyList()))
}

fun QuartzParser.ExpressionContext.toNode(): Expression {
    return errorScope({ "expression $text" }) {
        when {
            expression() == null -> disjunction().toNode()
            else -> Assignment(disjunction().toNode(), expression().toNode(), assignmentOperator().ID, null)
        }
    }
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
        memberAccess() != null -> memberAccess().toNode(expression)
        postfixCall() != null -> postfixCall().toNode(expression)
        else -> PostfixUnaryOperator(expression, ID, null)
    }
}

fun QuartzParser.AtomicExpressionContext.toNode(): Expression {
    return when {
        expression() != null -> expression().toNode()
        lambda() != null -> lambda().toNode()
        ifExpression() != null -> ifExpression().toNode()
        sizeof() != null -> sizeof().toNode()
        identifier() != null -> identifier().toNode()
        inlineC() != null -> inlineC().toNode()
        literal() != null -> literal().toNode()
        else -> throw QuartzException("Unrecognized atomic expression $text")
    }
}

fun QuartzParser.MemberAccessContext.toNode(expression: Expression): MemberAccess {
    return MemberAccess(identifier().text, expression, null)
}

fun QuartzParser.PostfixCallContext.toNode(expression: Expression): FunctionCall {
    return FunctionCall(
            expression,
            expressionList().expression().map { it.toNode() },
            null
    )
}

fun QuartzParser.LambdaContext.toNode(): Lambda {
    return Lambda(
            fnArgumentList().fnArgument().map { it.identifier().text },
            Function(
                    fnArgumentList().fnArgument().map { it.type().toType() },
                    returnType?.toType(),
                    emptyList(),
                    false
            ),
            fnBlock().toNode()
    )
}

fun QuartzParser.IfExpressionContext.toNode(): IfExpression {
    return IfExpression(test.toNode(), ifTrue.toNode(), ifFalse.toNode(), null)
}

fun QuartzParser.SizeofContext.toNode(): Sizeof {
    return Sizeof(type().toType())
}

fun QuartzParser.IdentifierContext.toNode(): Identifier {
    return Identifier(IDENTIFIER().text, typeList()?.type()?.map { it.toType() } ?: emptyList(), null)
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

val QuartzParser.AssignmentOperatorContext.ID: Assignment.ID
    get() = when (text) {
        "=" -> Assignment.ID.EQ
        "+=" -> Assignment.ID.PLUS_EQ
        "-=" -> Assignment.ID.MINUS_EQ
        "*=" -> Assignment.ID.TIMES_EQ
        "/=" -> Assignment.ID.DIV_EQ
        "%=" -> Assignment.ID.MOD_EQ
        else -> throw QuartzException("Unrecognized assignment operator $text")
    }

val QuartzParser.EqualityOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        "==" -> BinaryOperator.ID.EQ
        "!=" -> BinaryOperator.ID.NEQ
        else -> throw QuartzException("Unrecognized equality operator $text")
    }

val QuartzParser.ComparisonOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        ">" -> BinaryOperator.ID.GT
        "<" -> BinaryOperator.ID.LT
        ">=" -> BinaryOperator.ID.GEQ
        "<=" -> BinaryOperator.ID.LEQ
        else -> throw QuartzException("Unrecognized comparison operator $text")
    }

val QuartzParser.AdditiveOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        "+" -> BinaryOperator.ID.ADD
        "-" -> BinaryOperator.ID.SUBT
        else -> throw QuartzException("Unrecognized additive operator $text")
    }

val QuartzParser.MultiplicativeOperationContext.ID: BinaryOperator.ID
    get() = when (text) {
        "*" -> BinaryOperator.ID.MULT
        "/" -> BinaryOperator.ID.DIV
        "%" -> BinaryOperator.ID.MOD
        else -> throw QuartzException("Unrecognized multiplicative operator $text")
    }

val QuartzParser.PrefixOperationContext.ID: PrefixUnaryOperator.ID
    get() = when (text) {
        "++" -> PrefixUnaryOperator.ID.INCREMENT
        "--" -> PrefixUnaryOperator.ID.DECREMENT
        "-" -> PrefixUnaryOperator.ID.NEGATE
        "!" -> PrefixUnaryOperator.ID.INVERT
        else -> throw QuartzException("Unrecognized prefix operator $text")
    }

val QuartzParser.PostfixOperationContext.ID: PostfixUnaryOperator.ID
    get() = when (text) {
        "++" -> PostfixUnaryOperator.ID.INCREMENT
        "--" -> PostfixUnaryOperator.ID.DECREMENT
        else -> throw QuartzException("Unrecognized postfix operator $text")
    }
