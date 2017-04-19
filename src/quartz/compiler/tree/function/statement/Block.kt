package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class Block(val statements: List<Statement>) : Statement {
    override fun mapStatements(function: (Statement) -> Statement): Block {
        return Block(statements.map { function(it.mapStatements(function)) })
    }

    override fun getExpressions(): List<Expression> {
        return statements.map { it.getExpressions() }.flatten()
    }

    override fun mapExpressions(function: (Expression) -> Expression): Block {
        return Block(statements.map { it.mapExpressions(function) })
    }

    override fun mapTypes(function: (Type?) -> Type?): Block {
        return Block(statements.map { it.mapTypes(function) })
    }

    override fun toString(): String {
        return "Block $statements"
    }

    override fun toString(i: Int): String {
        var s = ""
        statements.forEach { s += "${it.toString(i)}\n" }
        return s
    }
}
