package quartz.compiler.syntax.tree.program.function.expression

import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class IfExpressionNode(val test: ExpressionNode, val ifTrue: ExpressionNode, val ifFalse: ExpressionNode, override val type: Type?) : ExpressionNode {
    override fun withType(type: Type?): IfExpressionNode {
        return IfExpressionNode(test, ifTrue, ifFalse, type)
    }

    override fun toString(): String {
        return "if ($test) $ifTrue else $ifFalse"
    }
}
