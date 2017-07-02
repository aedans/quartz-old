package quartz.compiler.generator.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.UnitExpression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class VariableDeclaration(
        val name: String,
        val variableType: Type?,
        val value: Expression?
) : UnitExpression() {
    override fun toString(): String {
        return "$variableType $name = $value"
    }
}
