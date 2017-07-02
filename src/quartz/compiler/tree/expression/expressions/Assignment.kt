package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.LValue
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class Assignment(val lvalue: LValue, val expression: Expression, override val type: Type?) : Expression {
    override fun withType(type: Type): Assignment {
        return Assignment(lvalue, expression, type)
    }

    override fun toString(): String {
        return "$lvalue = $expression"
    }
}
