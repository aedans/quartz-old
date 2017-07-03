package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

data class IfExpression(
        val condition: Expression,
        val ifTrue: Expression,
        val ifFalse: Expression?,
        override val type: Type?
) : Expression {
    override fun withType(type: Type): IfExpression {
        return IfExpression(condition, ifTrue, ifFalse, type)
    }

    inline fun visitCondition(expressionVisitor: Visitor<Expression>): IfExpression {
        return copy(condition = expressionVisitor(condition))
    }

    inline fun visitIfTrue(expressionVisitor: Visitor<Expression>): IfExpression {
        return copy(ifTrue = expressionVisitor(ifTrue))
    }

    inline fun visitIfFalse(expressionVisitor: Visitor<Expression>): IfExpression {
        return copy(ifFalse = ifFalse?.let(expressionVisitor))
    }

    override fun toString(): String {
        return "if $condition then $ifTrue else $ifFalse"
    }
}
