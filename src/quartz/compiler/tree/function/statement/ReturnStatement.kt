package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class ReturnStatement(val expression: Expression) : Statement {
    override fun mapExpressions(function: (Expression) -> Expression): Statement {
        return ReturnStatement(function(expression.mapExpressions(function)))
    }

    override fun mapTypes(function: (Type?) -> Type?): Statement {
        return ReturnStatement(expression.mapTypes(function))
    }

    override fun toString(): String {
        return "return $expression"
    }
}
