package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class FunctionCall(
        val expression: Expression,
        val templates: List<Type>,
        val args: List<Expression>,
        override val type: Type?
) : Expression, Statement {
    override val isLValue = false

    override fun getExpressions(): List<Expression> {
        return expression.getExpressions() + args.map { it.getExpressions() }.flatten()
    }

    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return function(FunctionCall(
                function(expression.mapExpressions(function)),
                templates,
                args.map { it.mapExpressions(function) }.map(function),
                type
        ))
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return FunctionCall(
                expression.mapTypes(function),
                templates.map { function(it.mapTypes(function))!! },
                args.map { it.mapTypes(function) },
                function(type?.mapTypes(function))
        )
    }

    override fun withType(type: Type?): Expression {
        return FunctionCall(expression, templates, args, type)
    }

    override fun toString(): String {
        return "$expression${if (templates.isNotEmpty()) "<$templates>" else ""}$args"
    }
}
