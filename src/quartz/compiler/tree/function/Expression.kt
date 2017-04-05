package quartz.compiler.tree.function

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

interface Expression : Statement {
    val type: Type?

    fun withType(type: Type?): Expression

    override fun mapExpressions(function: (Expression) -> Expression): Expression

    override fun mapTypes(function: (Type?) -> Type?): Expression
}
