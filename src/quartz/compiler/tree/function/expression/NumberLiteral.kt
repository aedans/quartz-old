package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class NumberLiteral(val string: String, override val type: Type?) : Expression {
    override val isLValue = false

    override fun getExpressions(): List<Expression> {
        return listOf(this)
    }

    override fun getStatements(): List<Statement> {
        return emptyList()
    }

    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return this
    }

    override fun mapStatements(function: (Statement) -> Statement): Expression {
        return this
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return NumberLiteral(string, function(type?.mapTypes(function)))
    }

    override fun withType(type: Type?): NumberLiteral {
        return NumberLiteral(string, type)
    }

    override fun toString(): String {
        return string
    }
}
