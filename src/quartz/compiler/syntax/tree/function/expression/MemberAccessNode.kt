package quartz.compiler.syntax.tree.function.expression

import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class MemberAccessNode(val name: String, val expression: ExpressionNode, override val type: Type?): ExpressionNode {
    override fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): ExpressionNode {
        return MemberAccessNode(name, function(expression.mapExpressions(function)), type)
    }

    override fun mapTypes(function: (Type?) -> Type?): ExpressionNode {
        return MemberAccessNode(name, expression.mapTypes(function), function(type))
    }

    override fun withType(type: Type?): MemberAccessNode {
        return MemberAccessNode(name, expression, type)
    }

    override fun toString(): String {
        return "$expression.$name"
    }
}
