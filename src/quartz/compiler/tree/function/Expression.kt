package quartz.compiler.tree.function

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

interface Expression : Statement {
    val type: Type?
    val isLValue: Boolean

    fun withType(type: Type?): Expression
}
