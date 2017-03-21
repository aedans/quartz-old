package quartz.compiler.syntax.tree.program.function.expression

import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class UnaryOperatorNode(var expression: ExpressionNode, val id: ID, override var type: Type?) : ExpressionNode {
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