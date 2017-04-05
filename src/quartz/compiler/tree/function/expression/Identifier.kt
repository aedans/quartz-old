package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class Identifier(val name: String, override val type: Type?) : Expression {
    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return this
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return Identifier(name, function(type?.mapTypes(function)))
    }

    override fun withType(type: Type?): Expression {
        return Identifier(name, type)
    }

    override fun toString(): String {
        return name
    }
}
