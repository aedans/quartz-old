package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class MemberAccess(val name: String, val expression: Expression, override val type: Type?): Expression {
    override val isLValue = true

    override fun withType(type: Type?): MemberAccess {
        return MemberAccess(name, expression, type)
    }

    override fun toString(): String {
        return "$expression.$name"
    }
}
