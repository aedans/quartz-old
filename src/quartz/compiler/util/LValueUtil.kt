package quartz.compiler.util

import quartz.compiler.errors.except
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.LValue

/**
 * Created by Aedan Smith.
 */

fun Expression.lValueOrError(): LValue {
    return if (this is LValue) this else except { "$this is not an lvalue" }
}
