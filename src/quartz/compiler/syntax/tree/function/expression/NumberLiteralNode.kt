package quartz.compiler.syntax.tree.function.expression

import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class NumberLiteralNode(val string: String, override val type: Type?) : ExpressionNode {
    override fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): ExpressionNode {
        return this
    }

    override fun mapTypes(function: (Type?) -> Type?): ExpressionNode {
        return NumberLiteralNode(string, function(type?.mapTypes(function)))
    }

    override fun withType(type: Type?): NumberLiteralNode {
        return NumberLiteralNode(string, type)
    }

    override fun toString(): String {
        return string
    }
}
