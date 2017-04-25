package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class Identifier(val name: String, val templates: List<Type>, override val type: Type?) : Expression {
    override val isLValue = true

    override fun getExpressions(): List<Expression> {
        return listOf(this)
    }

    override fun getStatements(): List<Statement> {
        return emptyList()
    }

    override fun mapExpressions(function: (Expression) -> Expression): Identifier {
        return this
    }

    override fun mapStatements(function: (Statement) -> Statement): Identifier {
        return this
    }

    override fun mapTypes(function: (Type?) -> Type?): Identifier {
        return Identifier(name, templates.map { function(it.mapTypes(function))!! }, function(type?.mapTypes(function)))
    }

    override fun withType(type: Type?): Identifier {
        return Identifier(name, templates, type)
    }

    override fun toString(): String {
        return "$name${if (!templates.isEmpty()) templates.joinToString(prefix = "<", postfix = ">") { it.toString() } else ""}"
    }
}
