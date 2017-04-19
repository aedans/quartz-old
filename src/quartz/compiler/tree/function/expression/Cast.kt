package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class Cast(val expression: Expression, override val type: Type?) : Expression {
    override val isLValue = false

    override fun getExpressions(): List<Expression> {
        return expression.getExpressions() + this
    }

    override fun getStatements(): List<Statement> {
        return expression.getStatements()
    }

    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return Cast(function(expression.mapExpressions(function)), type)
    }

    override fun mapStatements(function: (Statement) -> Statement): Expression {
        return Cast(expression.mapStatements(function), type)
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return Cast(expression.mapTypes(function), function(type?.mapTypes(function)))
    }

    override fun withType(type: Type?): Cast {
        return Cast(expression, type)
    }

    override fun toString(): String {
        return "${if (type != null) "($type)" else ""} ($expression)"
    }
}
