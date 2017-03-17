package quartz.compiler.parser.nodes.expression

import quartz.compiler.parser.nodes.ExpressionNode
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
