package quartz.compiler.tree.function.expression

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.types.PointerType
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.tree.function.Expression
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

    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return this
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return this
    }

    override fun withType(type: Type?): Expression {
        if (type is PointerType && type.type == Primitives.char)
            return this
        else
            throw QuartzException("Could not cast $this to $type")
    }

    override fun toString(): String {
        return "\"$string\""
    }
}
