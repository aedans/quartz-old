package quartz.compiler.syntax.tree.function.statement

import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.syntax.tree.function.StatementNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class VarDeclarationNode(val name: String, val expression: ExpressionNode?, val type: Type?, val mutable: Boolean) : StatementNode {
    override fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): StatementNode {
        return VarDeclarationNode(name, expression?.mapExpressions(function)?.let(function), type, mutable)
    }

    override fun mapTypes(function: (Type?) -> Type?): StatementNode {
        return VarDeclarationNode(name, expression?.mapTypes(function), function(type?.mapTypes(function)), mutable)
    }

    override fun toString(): String {
        return "${if (mutable) "var" else "val"} $name${if (type == null) "" else ": " + type.toString()}" +
                if (expression != null) " = $expression" else ""
    }
}
