package quartz.compiler.syntax.tree.program.function.expression

import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class MemberAccessNode(val name: String, override var type: Type?, var expression: ExpressionNode): ExpressionNode {
    override fun toString(): String {
        return "$expression.$name: $type"
    }
}
