package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class Delete(val expression: Expression) : Statement {
    override fun getExpressions(): List<Expression> {
        return expression.getExpressions()
    }

    override fun getStatements(): List<Statement> {
        return expression.getStatements() + this
    }

    override fun mapStatements(function: (Statement) -> Statement): Statement {
        return this
    }

    override fun mapExpressions(function: (Expression) -> Expression): Statement {
        return Delete(function(expression.mapExpressions(function)))
    }

    override fun mapTypes(function: (Type?) -> Type?): Statement {
        return Delete(expression.mapTypes(function))
    }

    override fun toString(): String {
        return "delete $expression"
    }
}
