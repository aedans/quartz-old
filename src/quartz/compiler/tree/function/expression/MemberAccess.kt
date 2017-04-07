package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.LValueExpression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class MemberAccess(val name: String, val expression: Expression, override val type: Type?): LValueExpression {
    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return MemberAccess(name, function(expression.mapExpressions(function)), type)
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return MemberAccess(name, expression.mapTypes(function), function(type?.mapTypes(function)))
    }

    override fun withType(type: Type?): MemberAccess {
        return MemberAccess(name, expression, type)
    }

    override fun toString(): String {
        return "$expression.$name"
    }
}
