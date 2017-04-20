package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.util.Type
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

class TypeSwitch(val identifier: Identifier, val branches: Map<Type, Block>, val elseBranch: Block) : Statement {
    override fun getExpressions(): List<Expression> {
        return (branches.map { it.value.getExpressions() }).flatten() +
                elseBranch.getExpressions() +
                identifier.getExpressions()
    }

    override fun getStatements(): List<Statement> {
        return branches.map { it.value.getStatements() }.flatten() + elseBranch.getStatements()
    }

    override fun mapStatements(function: (Statement) -> Statement): TypeSwitch {
        return TypeSwitch(
                identifier.mapStatements(function),
                branches.mapValues { it.value.mapStatements(function) },
                elseBranch.mapStatements(function)
        )
    }

    override fun mapExpressions(function: (Expression) -> Expression): TypeSwitch {
        return TypeSwitch(
                identifier.mapExpressions(function),
                branches.mapValues { it.value.mapExpressions(function) },
                elseBranch.mapExpressions(function)
        )
    }

    override fun mapTypes(function: (Type?) -> Type?): TypeSwitch {
        return TypeSwitch(
                identifier.mapTypes(function),
                branches.map { function(it.key.mapTypes(function))!! to it.value.mapTypes(function) }.toMap(),
                elseBranch.mapTypes(function)
        )
    }

    override fun toString(): String {
        return "typeswitch ($identifier)"
    }

    override fun toString(i: Int): String {
        var s = "${"\t" * i}$this"
        branches.forEach {
            s += "\n${"\t" * i}${it.key} {\n${it.value.toString(i + 1)}${"\t" * i}}"
        }
        s += "\n${"\t" * i}else {${if (elseBranch.statementList.isEmpty()) " }" else "${elseBranch.toString(i + 1)}${"\t" * i}}"}"
        return s
    }
}
