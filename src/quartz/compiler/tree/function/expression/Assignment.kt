package quartz.compiler.tree.function.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class Assignment(val lvalue: Expression, val expression: Expression, val id: ID, override val type: Type?) : Expression {
    override val isLValue = false

    init {
        if (!lvalue.isLValue)
            throw QuartzException("$lvalue is not a valid lvalue")
    }

    override fun withType(type: Type?): Assignment {
        return Assignment(lvalue, expression, id, type)
    }

    override fun toString(): String {
        return "$lvalue $id $expression"
    }

    enum class ID(val string: String) {
        EQ("="),
        PLUS_EQ("+="),
        MINUS_EQ("-="),
        TIMES_EQ("*="),
        DIV_EQ("/="),
        MOD_EQ("%="),
        BAND_EQ("&="),
        BOR_EQ("|="),
        BXOR_EQ("^="),
        SHR_EQ(">>="),
        SHL_EQ("<<=");

        override fun toString(): String {
            return string
        }
    }
}
