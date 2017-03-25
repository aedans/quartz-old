package quartz.compiler.syntax.tree.function.expression

import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class CastNode(override val type: Type?, val expression: ExpressionNode) : ExpressionNode {
    override fun withType(type: Type?): CastNode {
        return CastNode(type, expression)
    }

    override fun toString(): String {
        return "${if (type != null) "($type)" else ""} ($expression)"
    }
}
