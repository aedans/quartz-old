package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class PostfixUnaryOperator(val expression: Expression, val id: ID, override val type: Type?) : Expression {
    override val isLValue = false

    override fun withType(type: Type?): PostfixUnaryOperator {
        return PostfixUnaryOperator(expression, id, type)
    }

    override fun toString(): String {
        return "$expression$id"
    }

    enum class ID(val string: String) {
        INCREMENT("++"),
        DECREMENT("--");

        override fun toString(): String {
            return string
        }
    }
}