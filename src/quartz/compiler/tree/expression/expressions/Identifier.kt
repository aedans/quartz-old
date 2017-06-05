package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class Identifier(val name: String, override val type: Type?) : Expression {
    override val isLValue = true

    override fun withType(type: Type?): Identifier {
        return Identifier(name, type)
    }

    override fun toString(): String {
        return name
    }
}
