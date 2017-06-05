package quartz.compiler.tree.expression.expressions

import quartz.compiler.errors.QuartzException
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class Assignment(val lvalue: Expression, val expression: Expression, override val type: Type?) : Expression {
    override val isLValue = false

    init {
        if (!lvalue.isLValue)
            throw QuartzException("$lvalue is not a valid lvalue")
    }

    override fun withType(type: Type?): Assignment {
        return Assignment(lvalue, expression, type)
    }

    override fun toString(): String {
        return "$lvalue = $expression"
    }
}
