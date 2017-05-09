package quartz.compiler.tree.function.expression

import quartz.compiler.semantics.types.Primitives
import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class Sizeof(val sizeType: Type) : Expression {
    override val isLValue = false
    override val type = Primitives.ulong

    override fun withType(type: Type?): Expression {
        return this
    }

    override fun toString(): String {
        return "sizeof($sizeType)"
    }
}
