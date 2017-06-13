package quartz.compiler.generator

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.types.VoidType
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.declarations.InlineC
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.*
import quartz.compiler.util.withLast

/**
 * Created by Aedan Smith.
 */

fun FunctionDeclaration.desugar(): FunctionDeclaration {
    return copy(block = (
            if (function.returnType == VoidType) block else Block(block.withLast(ReturnExpression(block.last())))
            ).desugar((0..Integer.MAX_VALUE).iterator()))
}

fun Block.desugar(intIterator: IntIterator): Block {
    val newExpressions = mutableListOf<Expression>()
    forEach { newExpressions.add(it.desugar(newExpressions, intIterator, true)) }
    return Block(newExpressions)
}

fun Expression.desugar(newExpressions: MutableList<Expression>, intIterator: IntIterator, isStatement: Boolean = false): Expression {
    return when (this) {
        is InlineC -> this
        is NumberLiteral -> this
        is StringLiteral -> this
        is Identifier -> this
        is Sizeof -> this
        is Cast -> copy(expression = expression.desugar(newExpressions, intIterator))
        is ReturnExpression -> copy(expression = expression.desugar(newExpressions, intIterator))
        is UnaryOperator -> copy(expression = expression.desugar(newExpressions, intIterator))
        is BinaryOperator -> copy(
                expr1 = expr1.desugar(newExpressions, intIterator),
                expr2 = expr2.desugar(newExpressions, intIterator)
        )
        is Assignment -> copy(
                lvalue = lvalue.desugar(newExpressions, intIterator),
                expression = expression.desugar(newExpressions, intIterator)
        )
        is FunctionCall -> copy(
                expression = expression.desugar(newExpressions, intIterator),
                args = args.map { it.desugar(newExpressions, intIterator) }
        )
        is IfExpression -> desugar(newExpressions, intIterator, isStatement)
        is VariableDeclaration -> copy(
                expression = expression?.desugar(newExpressions, intIterator)
        )
        is Block -> desugar(intIterator)
        else -> throw QuartzException("Expected expression, found $this")
    }
}

fun IfExpression.desugar(newExpressions: MutableList<Expression>, intIterator: IntIterator, isTop: Boolean): Expression {
    return if (isTop) this else {
        val name = "__${intIterator.next()}"
        val identifier = Identifier(name, type)
        newExpressions.add(VariableDeclaration(name, null, type))
        newExpressions.add(IfExpression(
                condition.desugar(newExpressions, intIterator),
                Block(ifTrue.withLast(Assignment(identifier, ifTrue.last(), type))).desugar(intIterator),
                Block(ifFalse.withLast(Assignment(identifier, ifFalse.last(), type))).desugar(intIterator),
                type
        ))
        return identifier
    }
}
