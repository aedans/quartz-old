package quartz.compiler.tree.misc

import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

open class InlineC(val src: String, override val type: Type? = null) : GlobalDeclaration, Expression {
    override val isLValue = true

    override fun withType(type: Type?): Expression {
        return InlineC(src, type)
    }

    override fun toString(): String {
        return "InlineC"
    }
}
