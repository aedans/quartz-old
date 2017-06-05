package quartz.compiler.generator.translator

import quartz.compiler.errors.QuartzException
import quartz.compiler.tree.expression.Block
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.expression.expressions.*
import quartz.compiler.tree.declarations.InlineC

/**
 * Created by Aedan Smith.
 */

fun FunctionDeclaration.simplify(): FunctionDeclaration {
    return copy(block = block.simplify((0..Integer.MAX_VALUE).iterator()))
}

fun Block.simplify(intIterator: IntIterator): BlockExpression {
    val newExpressions = mutableListOf<Expression>()
    expressionList.forEach { newExpressions.add(it.simplify(newExpressions, intIterator, true)) }
    return BlockExpression(newExpressions)
}

fun Expression.simplify(newExpressions: MutableList<Expression>, intIterator: IntIterator, isTop: Boolean = false): Expression {
    return when (this) {
        is InlineC -> this
        is NumberLiteral -> this
        is StringLiteral -> this
        is Identifier -> this
        is Sizeof -> this
        is Cast -> copy(expression = expression.simplify(newExpressions, intIterator))
        is ReturnExpression -> copy(expression = expression.simplify(newExpressions, intIterator))
        is UnaryOperator -> copy(expression = expression.simplify(newExpressions, intIterator))
        is BinaryOperator -> copy(
                expr1 = expr1.simplify(newExpressions, intIterator),
                expr2 = expr2.simplify(newExpressions, intIterator)
        )
        is Assignment -> copy(
                lvalue = lvalue.simplify(newExpressions, intIterator),
                expression = expression.simplify(newExpressions, intIterator)
        )
        is FunctionCall -> copy(
                expression = expression.simplify(newExpressions, intIterator),
                args = args.map { it.simplify(newExpressions, intIterator) }
        )
        is IfExpression -> simplify(newExpressions, intIterator, isTop)
        is VariableDeclaration -> copy(
                expression = expression?.simplify(newExpressions, intIterator)
        )
        is BlockExpression -> simplify(intIterator)
        else -> throw QuartzException("Expected expression, found $this")
    }
}

fun IfExpression.simplify(newExpressions: MutableList<Expression>, intIterator: IntIterator, isTop: Boolean): Expression {
    return if (isTop) this else {
        type!!
        val name = "__${intIterator.next()}"
        val identifier = Identifier(name, type)
        newExpressions.add(VariableDeclaration(name, null, type))
        newExpressions.add(IfExpression(
                condition.simplify(newExpressions, intIterator),
                ifTrue.setLast(Assignment(identifier, ifTrue.expressionList.last(), type)).simplify(intIterator),
                ifFalse.setLast(Assignment(identifier, ifFalse.expressionList.last(), type)).simplify(intIterator),
                type
        ))
        return identifier
    }
}
