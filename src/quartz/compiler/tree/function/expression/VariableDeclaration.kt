package quartz.compiler.tree.function.expression

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.UnitExpression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class VariableDeclaration(
        val name: String,
        val expression: Expression?,
        val varType: Type?,
        val mutable: Boolean
): UnitExpression() {
    override fun toString(): String {
        return "${if (mutable) "var" else "val"} $name: $varType" +
                if (expression != null) " = $expression" else ""
    }
}
