package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class ArrayAccess(val lvalue: Expression, val expr2: Expression, override val type: Type?) : Expression {
    override val isLValue = true

    override fun getExpressions(): List<Expression> {
        return listOf(this) + lvalue.getExpressions() + expr2.getExpressions()
    }

    override fun withType(type: Type?): Expression {
        return ArrayAccess(lvalue, expr2, type)
    }

    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return ArrayAccess(function(lvalue.mapExpressions(function)), function(expr2.mapExpressions(function)), type)
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return ArrayAccess(lvalue, expr2, function(type?.mapTypes(function)))
    }

    override fun toString(): String {
        return "$lvalue[$expr2]"
    }
}
