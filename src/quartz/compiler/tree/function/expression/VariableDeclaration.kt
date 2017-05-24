package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.UnitExpression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class VariableDeclaration(
        val name: String,
        val expression: Expression?,
        val variableType: Type?,
        val mutable: Boolean
): UnitExpression() {
    override fun toString(): String {
        return "${if (mutable) "var" else "val"} $name: $variableType" +
                if (expression != null) " = $expression" else ""
    }
}
