package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.LValue
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class Identifier(val name: String, override val type: Type?) : LValue {
    override fun toString(): String {
        return name
    }
}
