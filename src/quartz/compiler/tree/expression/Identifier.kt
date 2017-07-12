package quartz.compiler.tree.expression

import quartz.compiler.tree.Type

/**
 * Created by Aedan Smith.
 */

data class Identifier(val name: String, override val type: Type?) : LValue {
    override fun toString(): String {
        return name
    }
}
