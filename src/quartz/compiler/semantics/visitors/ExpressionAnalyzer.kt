package quartz.compiler.semantics.visitors

import quartz.compiler.errors.QuartzException
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

object ExpressionAnalyzer {
    fun verifyType(type: Type?, expression: Expression): Expression {
        return when {
            expression.type == null -> expression.withType(type)
            type == null || expression.type!!.isEqualTo(type) || type.isSupertype(expression.type!!) -> expression
            expression.type?.isSupertype(type) ?: true -> expression // TODO cast
            else -> throw QuartzException("Could not cast $expression (${expression.type}) to $type")
        }
    }
}
