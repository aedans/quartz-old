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
        val expressions: List<Expression>,
        override val type: Type?
) : Expression, Statement {
    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return function(FunctionCall(
                function(expression.mapExpressions(function)),
                templates,
                expressions.map { it.mapExpressions(function) }.map(function),
                type
        ))
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return FunctionCall(
                expression.mapTypes(function),
                templates.map { function(it.mapTypes(function))!! },
                expressions.map { it.mapTypes(function) },
                function(type?.mapTypes(function))
        )
    }

    override fun withType(type: Type?): Expression {
        return FunctionCall(expression, templates, expressions, type)
    }

    override fun toString(): String {
        return "$expression${if (templates.isNotEmpty()) "<$templates>" else ""}$expressions"
    }
}
