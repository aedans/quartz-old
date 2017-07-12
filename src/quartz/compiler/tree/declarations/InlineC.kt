package quartz.compiler.tree.declarations

import quartz.compiler.tree.Declaration
import quartz.compiler.tree.Expression
import quartz.compiler.tree.Type

/**
 * Created by Aedan Smith.
 */

data class InlineC(val src: String, override val type: Type?) : Declaration, Expression {
    override val name: String = "__InlineC${hashCode()}"

    override fun toString(): String {
        return "%%$src%%"
    }
}
