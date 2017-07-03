package quartz.compiler.tree.expression.expressions

import quartz.compiler.errors.except
import quartz.compiler.tree.VariableDeclaration
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.times

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

    inline fun visitVariableType(typeVisitor: Visitor<Type>): LetExpression {
        return copy(variableType = variableType?.let(typeVisitor))
    }

    inline fun visitValue(expressionVisitor: Visitor<Expression>): LetExpression {
        return copy(value = value?.let(expressionVisitor))
    }

    inline fun visitExpression(expressionVisitor: Visitor<Expression>): LetExpression {
        return copy(expression = expression.let(expressionVisitor))
    }

    fun declaration(): LetDeclaration {
        return LetDeclaration(name, variableType ?: except { "Unable to infer type for $this" })
    }

    override fun toString(): String {
        return "let $name: $variableType${if (value != null) " = $value" else ""} in $expression"
    }

    override fun toString(i: Int): String {
        return "${"\t" * i}let $name: $variableType${if (value != null) " = $value" else ""} in\n" +
                "${"\t" * i}$expression"
    }

    class LetDeclaration(override val name: String, override val type: Type) : VariableDeclaration
}
