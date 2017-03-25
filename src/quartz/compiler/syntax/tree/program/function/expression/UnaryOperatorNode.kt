package quartz.compiler.syntax.tree.program.function.expression

import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class UnaryOperatorNode(val expression: ExpressionNode, val id: ID, override val type: Type?) : ExpressionNode {
    override fun withType(type: Type?): UnaryOperatorNode {
        return UnaryOperatorNode(expression, id, type)
    }

    override fun toString(): String {
        return "$id($expression)"
    }

    enum class ID(val string: String) {
        INVERT("!"),
        NEGATE("-");

        override fun toString(): String {
            return string
        }
    }
}