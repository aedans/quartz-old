package quartz.compiler.tree.expression.expressions

import quartz.compiler.semantics.types.ULongType
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class Sizeof(val sizeType: Type) : Expression {
    override val isLValue = false
    override val type = ULongType

    override fun withType(type: Type): Expression {
        return this
    }

    override fun toString(): String {
        return "sizeof($sizeType)"
    }
}
