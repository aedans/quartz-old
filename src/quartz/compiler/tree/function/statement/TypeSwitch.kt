package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

class TypeSwitch(val type: Type, val branches: Map<Type, List<Statement>>, val elseBranch: List<Statement>) : Statement {
    override fun mapStatements(function: (Statement) -> Statement): TypeSwitch {
        return TypeSwitch(
                type,
                branches.mapValues { it.value.map(function) },
                elseBranch.map(function)
        )
    }

    override fun getExpressions(): List<Expression> {
        return (branches.map { it.value.map { it.getExpressions() }.flatten() } +
                elseBranch.map { it.getExpressions() }).flatten()
    }

    override fun mapExpressions(function: (Expression) -> Expression): TypeSwitch {
        return TypeSwitch(
                type,
                branches.mapValues { it.value.map { it.mapExpressions(function) } },
                elseBranch.map { it.mapExpressions(function) }
        )
    }

    override fun mapTypes(function: (Type?) -> Type?): TypeSwitch {
        return TypeSwitch(
                function(type.mapTypes(function))!!,
                branches.map { function(it.key.mapTypes(function))!! to it.value.map { it.mapTypes(function) } }.toMap(),
                elseBranch.map { it.mapTypes(function) }
        )
    }

    override fun toString(): String {
        return "switch ($type)"
    }

    override fun toString(i: Int): String {
        var s = ("|   " * i) + toString()
        branches.forEach {
            s += "\n" + ("|   " * i) + "${it.key}"
            it.value.forEach { s += "\n" + it.toString(i + 1) }
        }
        if (elseBranch.isNotEmpty()) {
            s += "\n" + ("|   " * i) + "else"
            elseBranch.forEach { s += "\n" + it.toString(i + 1) }
        }
        return s
    }
}
