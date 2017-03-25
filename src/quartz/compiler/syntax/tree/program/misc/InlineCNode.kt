package quartz.compiler.syntax.tree.program.misc

import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class InlineCNode(val src: String, override val type: Type? = null) : StatementNode, ExpressionNode {
    override fun withType(type: Type?): ExpressionNode {
        return InlineCNode(src, type)
    }

    override fun toString(): String {
        return "InlineCNode"
    }
}
