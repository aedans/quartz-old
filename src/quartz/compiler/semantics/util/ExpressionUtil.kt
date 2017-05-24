package quartz.compiler.semantics.util

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.types.ConstType
import quartz.compiler.semantics.types.InlineCType
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.expression.Cast
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

// TODO inline
fun Expression.verifyAs(type: Type?): Expression {
    return when {
        this.type == null || type is InlineCType -> this.withType(type)
        type == null || this.type!!.isEqualTo(type) -> this
        this.type?.isInstance(type) ?: true -> Cast(this, type)
        type is ConstType && type.type.isInstance(this.type!!) -> this.verifyAs(type.type)
        else -> throw QuartzException("Could not cast $this (${this.type}) to $type")
    }
}
