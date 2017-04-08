package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

class WhileLoop(val test: Expression, val statements: List<Statement>) : Statement {
    override fun mapStatements(function: (Statement) -> Statement): Statement {
        return WhileLoop(test, statements.map { function(it.mapStatements(function)) })
    }

    override fun getExpressions(): List<Expression> {
        return test.getExpressions() + statements.map { it.getExpressions() }.flatten()
    }

    override fun mapExpressions(function: (Expression) -> Expression): Statement {
        return WhileLoop(function(test.mapExpressions(function)), statements.map { it.mapExpressions(function) })
    }

    override fun mapTypes(function: (Type?) -> Type?): Statement {
        return WhileLoop(test.mapTypes(function), statements.map { it.mapTypes(function) })
    }

    override fun toString(): String {
        return "while ($test)"
    }

    override fun toString(i: Int): String {
        var s = ("|   " * i) + toString()
        statements.forEach {
            s += '\n' + it.toString(i + 1)
        }
        return s
    }
}
