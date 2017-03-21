package quartz.compiler.syntax.tree.program.function.expression

import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class IfExpressionNode(val test: ExpressionNode, var ifTrue: ExpressionNode, var ifFalse: ExpressionNode, override var type: Type?) : ExpressionNode {
    override fun toString(): String {
        return "if ($test) $ifTrue else $ifFalse"
    }
}
