package quartz.compiler.tree.expression

import quartz.compiler.tree.Expression

/**
 * Created by Aedan Smith.
 */

data class Assignment(val lvalue: LValue, val expression: Expression) : Expression {
    override val type = lvalue.type

    override fun toString(): String {
        return "$lvalue = $expression"
    }
}
