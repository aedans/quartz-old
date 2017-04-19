package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

class WhileLoop(val test: Expression, val block: Block) : Statement {
    override fun mapStatements(function: (Statement) -> Statement): Statement {
        return WhileLoop(test, block.mapStatements(function))
    }

    override fun getExpressions(): List<Expression> {
        return test.getExpressions() + block.getExpressions()
    }

    override fun mapExpressions(function: (Expression) -> Expression): Statement {
        return WhileLoop(function(test.mapExpressions(function)), block.mapExpressions(function))
    }

    override fun mapTypes(function: (Type?) -> Type?): Statement {
        return WhileLoop(test.mapTypes(function), block.mapTypes(function))
    }

    override fun toString(): String {
        return "while ($test)"
    }

    override fun toString(i: Int): String {
        return "${("|   " * i)}$this\n${block.toString(i+1)}"
    }
}
