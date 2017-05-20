package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class Identifier(val name: String, val genericArguments: List<Type>, override val type: Type?) : Expression {
    override val isLValue = true

    override fun withType(type: Type?): Identifier {
        return Identifier(name, genericArguments, type)
    }

    override fun toString(): String {
        return name
    }
}
