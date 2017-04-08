package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

class IfStatement(
        val test: Expression,
        val trueStatements: List<Statement>,
        val falseStatements: List<Statement>
) : Statement {
    override fun mapStatements(function: (Statement) -> Statement): Statement {
        return IfStatement(
                test,
                trueStatements.map { function(it.mapStatements(function)) },
                falseStatements.map { function(it.mapStatements(function)) }
        )
    }

    override fun getExpressions(): List<Expression> {
        return test.getExpressions() +
                trueStatements.map { it.getExpressions() }.flatten() +
                falseStatements.map { it.getExpressions() }.flatten()
    }

    override fun mapExpressions(function: (Expression) -> Expression): Statement {
        return IfStatement(
                function(test.mapExpressions(function)),
                trueStatements.map { it.mapExpressions(function) },
                falseStatements.map { it.mapExpressions(function) }
        )
    }

    override fun mapTypes(function: (Type?) -> Type?): Statement {
        return IfStatement(
                test.mapTypes(function),
                trueStatements.map { it.mapTypes(function) },
                falseStatements.map { it.mapTypes(function) }
        )
    }

    override fun toString(): String {
        return "if ($test)"
    }

    override fun toString(i: Int): String {
        var s = ("|   " * i) + toString()
        trueStatements.forEach {
            s += '\n' + it.toString(i + 1)
        }
        if (!falseStatements.isEmpty()) {
            s += '\n' + ("|   " * i) + "else"
            falseStatements.forEach {
                s += '\n' + it.toString(i + 1)
            }
        }
        return s
    }
}
