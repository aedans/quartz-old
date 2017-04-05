package quartz.compiler.tree.function

import quartz.compiler.util.Type
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

interface Statement {
    fun toString(i: Int): String {
        return ("|   " * i) + toString()
    }

    fun mapExpressions(function: (Expression) -> Expression): Statement

    fun mapTypes(function: (Type?) -> Type?): Statement
}
