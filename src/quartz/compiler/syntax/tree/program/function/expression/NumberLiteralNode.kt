package quartz.compiler.syntax.tree.program.function.expression

import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class NumberLiteralNode(val string: String, override val type: Type?) : ExpressionNode {
    override fun withType(type: Type?): NumberLiteralNode {
        return NumberLiteralNode(string, type)
    }

    override fun toString(): String {
        return "$string: $type"
    }
}
