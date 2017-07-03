package quartz.compiler.tree.expression.expressions

import quartz.compiler.semantics.types.ULongType
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

data class Sizeof(val sizeType: Type) : Expression {
    override val type: Type? = ULongType

    override fun withType(type: Type): Expression {
        return this
    }

    inline fun visitSizeType(typeVisitor: Visitor<Type>): Sizeof {
        return copy(sizeType = typeVisitor(sizeType))
    }

    override fun toString(): String {
        return "sizeof<$sizeType>"
    }
}
