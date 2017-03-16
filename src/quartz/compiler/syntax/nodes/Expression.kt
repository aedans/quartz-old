package quartz.compiler.syntax.nodes

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

interface Expression {
    val evalType: Type

    fun visit(builder: StringBuilder)
}
