package quartz.compiler.tree.declarations

import quartz.compiler.tree.Declaration
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class InlineC(val src: String, override val type: Type?) : Declaration, Expression {
    override val isLValue = true
    override val name: String = "__InlineC${hashCode()}"

    override fun withType(type: Type): Expression {
        return InlineC(src, type)
    }

    override fun toString(): String {
        return "%%$src%%"
    }
}
