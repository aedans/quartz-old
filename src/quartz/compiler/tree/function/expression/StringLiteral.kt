package quartz.compiler.tree.function.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.types.PointerType
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class StringLiteral(val string: String) : Expression {
    override val isLValue = false
    override val type = PointerType(Primitives.char)

    override fun getExpressions(): List<Expression> {
        return listOf(this)
    }

    override fun getStatements(): List<Statement> {
        return emptyList()
    }

    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return this
    }

    override fun mapStatements(function: (Statement) -> Statement): Expression {
        return this
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return this
    }

    override fun withType(type: Type?): Expression {
        if (type is PointerType && type.type.isInstance(Primitives.char))
            return this
        else
            throw QuartzException("Could not cast $this to $type")
    }

    override fun toString(): String {
        return "\"$string\""
    }
}
