package quartz.compiler.tree.misc

import quartz.compiler.tree.Declaration
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class InlineC(val src: String, override val type: Type? = null) : Declaration, Expression {
    override val isLValue = true
    override val name: String = "__InlineC${hashCode()}"

    override fun withType(type: Type?): Expression {
        return InlineC(src, type)
    }

    override fun toString(): String {
        return "InlineC"
    }
}
