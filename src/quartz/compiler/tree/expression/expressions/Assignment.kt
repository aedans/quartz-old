package quartz.compiler.tree.expression.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.LValue

/**
 * Created by Aedan Smith.
 */

data class Assignment(val lvalue: LValue, val expression: Expression) : Expression {
    override val type = lvalue.type

    override fun toString(): String {
        return "$lvalue = $expression"
    }
}
