package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

data class Cast(val expression: Expression, override val type: Type) : Expression {
    override fun withType(type: Type): Cast {
        return Cast(expression, type)
    }

    inline fun visitExpression(expressionVisitor: Visitor<Expression>): Cast {
        return copy(expression = expressionVisitor(expression))
    }

    inline fun visitType(typeVisitor: Visitor<Type>): Cast {
        return copy(type = typeVisitor(type))
    }

    override fun toString(): String {
        return "($expression) as $type"
    }
}
