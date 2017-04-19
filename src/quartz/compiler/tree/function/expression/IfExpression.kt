package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class IfExpression(val test: Expression, val ifTrue: Expression, val ifFalse: Expression, override val type: Type?) : Expression {
    override val isLValue = false

    override fun getExpressions(): List<Expression> {
        return test.getExpressions() + ifTrue.getExpressions() + ifFalse.getExpressions() + this
    }

    override fun getStatements(): List<Statement> {
        return test.getStatements() + ifTrue.getStatements() + ifFalse.getStatements()
    }

    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return IfExpression(
                function(test.mapExpressions(function)),
                function(ifTrue.mapExpressions(function)),
                function(ifFalse.mapExpressions(function)),
                type
        )
    }

    override fun mapStatements(function: (Statement) -> Statement): Expression {
        return IfExpression(
                test.mapStatements(function),
                ifTrue.mapStatements(function),
                ifFalse.mapStatements(function),
                type
        )
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return IfExpression(
                test.mapTypes(function),
                ifTrue.mapTypes(function),
                ifFalse.mapTypes(function),
                function(type?.mapTypes(function))
        )
    }

    override fun withType(type: Type?): IfExpression {
        return IfExpression(test, ifTrue, ifFalse, type)
    }

    override fun toString(): String {
        return "if ($test) $ifTrue else $ifFalse"
    }
}
