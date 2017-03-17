package quartz.compiler.tree.expression

import quartz.compiler.tree.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class NumberLiteralNode(val string: String, override var type: Type?) : ExpressionNode {
    override fun toString(): String {
        return "$string: $type"
    }
}
