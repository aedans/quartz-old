package quartz.compiler.syntax.tree.misc

import quartz.compiler.syntax.tree.GlobalDeclarationNode
import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.syntax.tree.function.StatementNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class InlineCNode(val src: String, override val type: Type? = null) : GlobalDeclarationNode, StatementNode, ExpressionNode {
    override fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): ExpressionNode {
        return this
    }

    override fun mapTypes(function: (Type?) -> Type?): ExpressionNode {
        return InlineCNode(src, function(type))
    }

    override fun withType(type: Type?): ExpressionNode {
        return InlineCNode(src, type)
    }

    override fun toString(): String {
        return "InlineCNode"
    }
}
