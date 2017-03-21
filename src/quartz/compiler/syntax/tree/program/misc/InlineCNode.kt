package quartz.compiler.syntax.tree.program.misc

import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class InlineCNode(val src: String) : StatementNode, ExpressionNode {
    override var type: Type? = null

    override fun toString(): String {
        return "InlineCNode"
    }
}
