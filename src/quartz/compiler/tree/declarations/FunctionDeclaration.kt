package quartz.compiler.tree.declarations

import quartz.compiler.tree.Declaration
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Function
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

data class FunctionDeclaration(
        override val name: String,
        val argNames: List<String>,
        val function: Function,
        val expression: Expression
) : Declaration {
    inline fun visitFunction(functionVisitor: Visitor<Function>): FunctionDeclaration {
        return copy(function = functionVisitor(function))
    }

    inline fun visitExpression(expressionVisitor: Visitor<Expression>): FunctionDeclaration {
        return copy(expression = expressionVisitor(expression))
    }

    override fun toString(): String {
        return "$name$function\n${expression.toString(1)}"
    }
}
