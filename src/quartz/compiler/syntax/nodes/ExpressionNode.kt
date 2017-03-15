package quartz.compiler.syntax.nodes

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

interface ExpressionNode {
    val evalType: Type

    fun visit(builder: StringBuilder)
}
