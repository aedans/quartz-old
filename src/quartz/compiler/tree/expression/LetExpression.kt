package quartz.compiler.tree.expression

import quartz.compiler.errors.except
import quartz.compiler.tree.Expression
import quartz.compiler.tree.Type
import quartz.compiler.tree.declarations.VariableDeclaration

/**
 * Created by Aedan Smith.
 */

data class LetExpression(
        val name: String,
        val value: Expression?,
        val variableType: Type?,
        val expression: Expression
): Expression {
    override val type = expression.type

    fun declaration(): LetDeclaration {
        return LetDeclaration(name, variableType ?: except { "Unable to infer type for $this" })
    }

    override fun toString(): String {
        return "let $name${variableType?.let { ": $it" } ?: ""}${value?.let { "= $it" } ?: ""} in $expression"
    }

    class LetDeclaration(override val name: String, override val type: Type) : VariableDeclaration
}
