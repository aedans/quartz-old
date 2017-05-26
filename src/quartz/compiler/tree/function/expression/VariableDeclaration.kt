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
        val variableType: Type?
): UnitExpression() {
    override fun toString(): String {
        return "let $name: $variableType" +
                if (expression != null) " = $expression" else ""
    }
}
