package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class VariableDeclaration(val name: String, val expression: Expression?, val type: Type?, val mutable: Boolean) : Statement {
    override fun mapExpressions(function: (Expression) -> Expression): Statement {
        return VariableDeclaration(name, expression?.mapExpressions(function)?.let(function), type, mutable)
    }

    override fun mapTypes(function: (Type?) -> Type?): Statement {
        return VariableDeclaration(name, expression?.mapTypes(function), function(type?.mapTypes(function)), mutable)
    }

    override fun toString(): String {
        return "${if (mutable) "var" else "val"} $name${if (type == null) "" else ": " + type.toString()}" +
                if (expression != null) " = $expression" else ""
    }
}
