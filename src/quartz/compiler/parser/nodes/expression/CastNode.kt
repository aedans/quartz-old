package quartz.compiler.parser.nodes.expression

import quartz.compiler.parser.nodes.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class CastNode(override var type: Type?, val expression: ExpressionNode) : ExpressionNode {
    override fun toString(): String {
        return "${if (type != null) "($type)" else ""} ($expression)"
    }
}
