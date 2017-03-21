package quartz.compiler.syntax.tree.program.function.expression

import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class BinaryOperatorNode(var expr1: ExpressionNode, var expr2: ExpressionNode, val id: ID, override var type: Type?) : ExpressionNode {
    override fun toString(): String {
        return "$id($expr1, $expr2)"
    }

    enum class ID(val string: String) {
        OR("||"),
        AND("&&"),
        EQUALS("=="),
        NOT_EQUALS("!="),
        LESS_THAN("<"),
        GREATER_THAN(">"),
        LESS_THAN_OR_EQUALS("<="),
        GREATER_THAN_OR_EQUALS(">="),
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/"),
        MOD("%"),
        ARRAY_ACCESS("[]");

        override fun toString(): String {
            return string
        }
    }
}
