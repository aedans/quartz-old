package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.ExpressionNode
import quartz.compiler.tree.function.StatementNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class VarAssignmentNode(val name: String, val expression: ExpressionNode) : StatementNode {
    override fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): StatementNode {
        return VarAssignmentNode(name, function(expression.mapExpressions(function)))
    }

    override fun mapTypes(function: (Type?) -> Type?): StatementNode {
        return VarAssignmentNode(name, expression.mapTypes(function))
    }

    override fun toString(): String {
        return "$name = $expression"
    }
}
