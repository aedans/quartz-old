package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class MemberAccess(val name: String, val expression: Expression, override val type: Type?): Expression {
    override val isLValue = true

    override fun getExpressions(): List<Expression> {
        return listOf(this) + expression.getExpressions()
    }

    override fun getStatements(): List<Statement> {
        return expression.getStatements()
    }

    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return MemberAccess(name, function(expression.mapExpressions(function)), type)
    }

    override fun mapStatements(function: (Statement) -> Statement): Expression {
        return MemberAccess(name, expression.mapStatements(function), type)
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
