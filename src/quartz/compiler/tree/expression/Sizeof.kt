package quartz.compiler.tree.expression

import quartz.compiler.tree.Expression
import quartz.compiler.tree.Type
import quartz.compiler.tree.types.ULongType

/**
 * Created by Aedan Smith.
 */

data class Sizeof(val sizeType: Type) : Expression {
    override val type = ULongType

    override fun toString(): String {
        return "sizeof<$sizeType>"
    }
}
