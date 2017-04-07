package quartz.compiler.tree.function

import quartz.compiler.exceptions.QuartzException

/**
 * Created by Aedan Smith.
 */

interface LValueExpression : Expression

fun Expression.toLValue(): LValueExpression {
    return this as? LValueExpression ?: throw QuartzException("$this is not an l-value")
}
