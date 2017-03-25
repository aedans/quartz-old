package quartz.compiler.syntax.tree.function

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

interface ExpressionNode {
    val type: Type?

    fun withType(type: Type?): ExpressionNode
}
