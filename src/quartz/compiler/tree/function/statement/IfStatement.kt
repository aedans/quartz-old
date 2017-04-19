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
        val trueBlock: Block,
        val falseBlock: Block
) : Statement {
    override fun getExpressions(): List<Expression> {
        return test.getExpressions() + trueBlock.getExpressions() + falseBlock.getExpressions()
    }

    override fun getStatements(): List<Statement> {
        return test.getStatements() + trueBlock.getStatements() + falseBlock.getStatements() + this
    }

    override fun mapStatements(function: (Statement) -> Statement): Statement {
        return IfStatement(
                test,
                trueBlock.mapStatements(function),
                falseBlock.mapStatements(function)
        )
    }

    override fun mapExpressions(function: (Expression) -> Expression): Statement {
        return IfStatement(
                function(test.mapExpressions(function)),
                trueBlock.mapExpressions(function),
                falseBlock.mapExpressions(function)
        )
    }

    override fun mapTypes(function: (Type?) -> Type?): Statement {
        return IfStatement(
                test.mapTypes(function),
                trueBlock.mapTypes(function),
                falseBlock.mapTypes(function)
        )
    }

    override fun toString(): String {
        return "if ($test)"
    }

    override fun toString(i: Int): String {
        return "${"|   " * i}$this\n${trueBlock.toString(i+1)}" +
                "${("|   " * i)}else${if (falseBlock.statementList.isEmpty()) "" else "\n${falseBlock.toString(i+1)}"}"
    }
}
