package quartz.compiler.semantics.analyzers.util

import quartz.compiler.errors.QuartzException
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

fun verifyType(type: Type?, expression: Expression): Expression {
    return when {
        expression.type == null -> expression.withType(type)
        type == null || expression.type!!.isConvertibleTo(type) || type.isConvertibleTo(expression.type!!) -> expression
        expression.type?.isConvertibleTo(type) ?: true -> expression // TODO cast
        else -> throw QuartzException("Could not cast $expression (${expression.type}) to $type")
    }
}
