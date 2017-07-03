package quartz.compiler.generator

import quartz.compiler.errors.err
import quartz.compiler.errors.except
import quartz.compiler.generator.expressions.VariableDeclaration
import quartz.compiler.semantics.types.VoidType
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.declarations.InlineC
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.*
import quartz.compiler.util.lValueOrError

/**
 * Created by Aedan Smith.
 */

fun FunctionDeclaration.desugar(): FunctionDeclaration {
    return copy(
            expression = (if (function.returnType == VoidType) expression else ReturnExpression(expression))
                    .desugar((0..Integer.MAX_VALUE).iterator()))
}

fun Expression.desugar(intIterator: IntIterator): ExpressionList {
    val newExpressions = mutableListOf<Expression>()
    newExpressions.add(desugar(newExpressions, intIterator, true))
    return ExpressionList(newExpressions)
}

fun Expression.desugar(newExpressions: MutableList<Expression>, intIterator: IntIterator, isStatement: Boolean = false): Expression {
    return when (this) {
        EmptyExpression -> this
        is InlineC -> this
        is NumberLiteral -> this
        is StringLiteral -> this
        is Identifier -> this
        is Sizeof -> this
        is Cast -> copy(expression = expression.desugar(newExpressions, intIterator))
        is UnaryOperation -> copy(expression = expression.desugar(newExpressions, intIterator))
        is BinaryOperation -> copy(
                expr1 = expr1.desugar(newExpressions, intIterator),
                expr2 = expr2.desugar(newExpressions, intIterator)
        )
        is Assignment -> copy(
                lvalue = lvalue.desugar(newExpressions, intIterator).lValueOrError(),
                expression = expression.desugar(newExpressions, intIterator)
        )
        is FunctionCall -> copy(
                expression = expression.desugar(newExpressions, intIterator),
                args = args.map { it.desugar(newExpressions, intIterator) }
        )
        is ExpressionPair -> desugar(newExpressions, intIterator, isStatement)
        is ReturnExpression -> desugar(newExpressions, intIterator, isStatement)
        is IfExpression -> desugar(newExpressions, intIterator, isStatement)
        is LetExpression -> desugar(newExpressions, intIterator, isStatement)
        is VariableDeclaration -> desugar(newExpressions, intIterator, isStatement)
        is ExpressionList -> desugar(newExpressions, intIterator, isStatement)
        else -> err { "Expected expression, found $this" }
    }
}

fun ExpressionPair.desugar(newExpressions: MutableList<Expression>, intIterator: IntIterator, isStatement: Boolean): Expression {
    return if (isStatement) {
        newExpressions.add(expr1.desugar(newExpressions, intIterator, true))
        expr2.desugar(newExpressions, intIterator, true)
    } else {
        copy(
                expr1 = expr1.desugar(newExpressions, intIterator),
                expr2 = expr2.desugar(newExpressions, intIterator)
        )
    }
}

fun ReturnExpression.desugar(newExpressions: MutableList<Expression>, intIterator: IntIterator, isStatement: Boolean): Expression {
    return if (isStatement) {
        copy(expression = expression.desugar(newExpressions, intIterator))
    } else except { "$this in invalid context" }
}

fun IfExpression.desugar(newExpressions: MutableList<Expression>, intIterator: IntIterator, isStatement: Boolean): Expression {
    return if (isStatement) {
        copy(
                condition = condition.desugar(newExpressions, intIterator),
                ifTrue = ifTrue.desugar(intIterator),
                ifFalse = ifFalse?.desugar(intIterator)
        )
    } else {
        val name = "__${intIterator.next()}"
        val identifier = Identifier(name, type)
        newExpressions.add(VariableDeclaration(name, type, null))
        newExpressions.add(IfExpression(
                condition,
                Assignment(identifier, ifTrue),
                ifFalse?.let { Assignment(identifier, it) }
        ).desugar(newExpressions, intIterator, true))
        identifier
    }
}

fun LetExpression.desugar(newExpressions: MutableList<Expression>, intIterator: IntIterator, isStatement: Boolean): Expression {
    newExpressions.add(VariableDeclaration(name, variableType, value).desugar(newExpressions, intIterator, true))
    return expression.desugar(newExpressions, intIterator, isStatement)
}

fun VariableDeclaration.desugar(newExpressions: MutableList<Expression>, intIterator: IntIterator, isStatement: Boolean): Expression {
    return if (isStatement) {
        copy(value = value?.desugar(newExpressions, intIterator))
    } else {
        newExpressions.add(desugar(newExpressions, intIterator, true))
        Identifier(name, variableType)
    }
}

fun ExpressionList.desugar(newExpressions: MutableList<Expression>, intIterator: IntIterator, isStatement: Boolean): Expression {
    return if (isStatement) {
        val localNewExpressions = mutableListOf<Expression>()
        forEach { newExpressions.add(it.desugar(newExpressions, intIterator, true)) }
        ExpressionList(localNewExpressions)
    } else {
        val name = "__${intIterator.next()}"
        newExpressions.add(VariableDeclaration(name, type, null))
        newExpressions.add(desugar(newExpressions, intIterator, true))
        Identifier(name, type)
    }
}
