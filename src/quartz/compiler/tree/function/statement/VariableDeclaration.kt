package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class VariableDeclaration(val name: String, val expression: Expression?, val type: Type?, val mutable: Boolean) : Statement {
    override fun toString(): String {
        return "${if (mutable) "var" else "val"} $name: $type" +
                if (expression != null) " = $expression" else ""
    }
}
