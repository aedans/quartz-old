package quartz.compiler.parser.nodes.expression

import quartz.compiler.parser.nodes.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class NumberLiteralNode(val string: String, override var type: Type?) : ExpressionNode {
    override fun toString(): String {
        return "$string: $type"
    }
}
