package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class IdentifierNode(val name: String, override val type: Type?) : ExpressionNode {
    override fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): ExpressionNode {
        return this
    }

    override fun mapTypes(function: (Type?) -> Type?): ExpressionNode {
        return IdentifierNode(name, function(type?.mapTypes(function)))
    }

    override fun withType(type: Type?): ExpressionNode {
        return IdentifierNode(name, type)
    }

    override fun toString(): String {
        return name
    }
}
