package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class FunctionCall(
        val expression: Expression,
        val args: List<Expression>,
        override val type: Type?
) : Expression, Statement {
    override val isLValue = false

    override fun getExpressions(): List<Expression> {
        return expression.getExpressions() + args.map { it.getExpressions() }.flatten()
    }

    override fun getStatements(): List<Statement> {
        return expression.getStatements() + args.map { it.getStatements() }.flatten() + this
    }

    override fun mapStatements(function: (Statement) -> Statement): Expression {
        return FunctionCall(
                expression.mapStatements(function),
                args.map { it.mapStatements(function) },
                type
        )
    }

    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return function(FunctionCall(
                function(expression.mapExpressions(function)),
                args.map { it.mapExpressions(function) }.map(function),
                type
        ))
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return FunctionCall(
                expression.mapTypes(function),
                args.map { it.mapTypes(function) },
                function(type?.mapTypes(function))
        )
    }

    override fun withType(type: Type?): Expression {
        return FunctionCall(expression, args, type)
    }

    override fun toString(): String {
        return args.joinToString(prefix = "(", postfix = ")") { it.toString() }
    }
}
