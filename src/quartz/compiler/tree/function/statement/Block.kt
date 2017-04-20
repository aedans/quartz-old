package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class Block(val statementList: List<Statement>) : Statement {
    override fun getExpressions(): List<Expression> {
        return statementList.map { it.getExpressions() }.flatten()
    }

    override fun getStatements(): List<Statement> {
        return statementList.map { it.getStatements() }.flatten() + this
    }

    override fun mapStatements(function: (Statement) -> Statement): Block {
        return Block(statementList.map { function(it.mapStatements(function)) })
    }

    override fun mapExpressions(function: (Expression) -> Expression): Block {
        return Block(statementList.map { it.mapExpressions(function) })
    }

    override fun mapTypes(function: (Type?) -> Type?): Block {
        return Block(statementList.map { it.mapTypes(function) })
    }

    override fun toString(): String {
        return "Block"
    }

    override fun toString(i: Int): String {
        var s = ""
        statementList.forEach { s += "${it.toString(i)}\n" }
        return s
    }
}
