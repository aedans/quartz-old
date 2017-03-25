package quartz.compiler.syntax.tree.program.function.expression

import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class MemberAccessNode(val name: String, override val type: Type?, val expression: ExpressionNode): ExpressionNode {
    override fun withType(type: Type?): MemberAccessNode {
        return MemberAccessNode(name, type, expression)
    }

    override fun toString(): String {
        return "$expression.$name${if (type != null) ": $type" else ""}"
    }
}
