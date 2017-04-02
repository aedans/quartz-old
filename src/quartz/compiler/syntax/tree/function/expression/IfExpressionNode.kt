package quartz.compiler.syntax.tree.function.expression

import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class IfExpressionNode(val test: ExpressionNode, val ifTrue: ExpressionNode, val ifFalse: ExpressionNode, override val type: Type?) : ExpressionNode {
    override fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): ExpressionNode {
        return IfExpressionNode(
                function(test.mapExpressions(function)),
                function(ifTrue.mapExpressions(function)),
                function(ifFalse.mapExpressions(function)),
                type
        )
    }

    override fun mapTypes(function: (Type?) -> Type?): ExpressionNode {
        return IfExpressionNode(test.mapTypes(function), ifTrue.mapTypes(function), ifFalse.mapTypes(function), function(type))
    }

    override fun withType(type: Type?): IfExpressionNode {
        return IfExpressionNode(test, ifTrue, ifFalse, type)
    }

    override fun toString(): String {
        return "if ($test) $ifTrue else $ifFalse"
    }
}
