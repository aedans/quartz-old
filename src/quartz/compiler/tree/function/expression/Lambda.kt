package quartz.compiler.tree.function.expression

import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class Lambda(
        val argNames: List<String>,
        override val type: FunctionType,
        val statements: List<Statement>
) : Expression {
    override val isLValue = false

    override fun withType(type: Type?): Expression {
        return Lambda(argNames, type as FunctionType, statements)
    }

    override fun getExpressions(): List<Expression> {
        return statements.map { it.getExpressions() }.flatten()
    }

    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return Lambda(argNames, type, statements.map { it.mapExpressions(function) })
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return Lambda(
                argNames,
                function(type.mapTypes(function)) as FunctionType,
                statements.map { it.mapTypes(function) }
        )
    }

    override fun toString(): String {
        return "${type.function} $statements"
    }
}
