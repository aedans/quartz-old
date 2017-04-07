package quartz.compiler.tree.function.expression

import quartz.compiler.semantics.types.Primitives
import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class Sizeof(val sizeType: Type) : Expression {
    override val type = Primitives.int

    override fun withType(type: Type?): Expression {
        return this
    }

    override fun mapExpressions(function: (Expression) -> Expression): Expression {
        return this
    }

    override fun mapTypes(function: (Type?) -> Type?): Expression {
        return Sizeof(function(sizeType.mapTypes(function))!!)
    }

    override fun toString(): String {
        return "sizeof($sizeType)"
    }
}
