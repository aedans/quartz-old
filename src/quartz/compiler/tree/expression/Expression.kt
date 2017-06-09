package quartz.compiler.tree.expression

import quartz.compiler.tree.util.Type
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

interface Expression {
    val type: Type?
    val isLValue: Boolean

    fun withType(type: Type?): Expression

    fun toString(i: Int): String {
        return ("\t" * i) + toString()
    }
}