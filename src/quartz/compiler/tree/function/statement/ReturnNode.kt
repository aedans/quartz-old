package quartz.compiler.tree.function.statement

import quartz.compiler.tree.function.ExpressionNode
import quartz.compiler.tree.function.StatementNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class ReturnNode(val expression: ExpressionNode) : StatementNode {
    override fun mapExpressions(function: (ExpressionNode) -> ExpressionNode): StatementNode {
        return ReturnNode(function(expression.mapExpressions(function)))
    }

    override fun mapTypes(function: (Type?) -> Type?): StatementNode {
        return ReturnNode(expression.mapTypes(function))
    }

    override fun toString(): String {
        return "return $expression"
    }
}
