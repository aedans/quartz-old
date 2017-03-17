package quartz.compiler.tree.expression

import quartz.compiler.tree.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class IdentifierNode(val name: String) : ExpressionNode {
    override var type: Type? = null

    override fun toString(): String {
        return name
    }
}
