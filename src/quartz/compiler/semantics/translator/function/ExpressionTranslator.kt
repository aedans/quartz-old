package quartz.compiler.semantics.translator.function

import quartz.compiler.semantics.translator.function.expressions.translate
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.syntax.tree.program.function.expression.*
import quartz.compiler.syntax.tree.program.function.statement.FnCallNode
import quartz.compiler.syntax.tree.program.misc.InlineCNode

/**
 * Created by Aedan Smith.
 */

fun ExpressionNode.translate(newStatements: MutableList<StatementNode>): ExpressionNode {
    return when (this) {
        is NumberLiteralNode -> this
        is StringLiteralNode -> this
        is InlineCNode -> this
        is IdentifierNode -> this
        is OneArgOperatorNode -> this
        is TwoArgOperatorNode -> this
        is CastNode -> this
        is FnCallNode -> this
        is IfExpressionNode -> translate(newStatements)
        is MemberAccessNode -> this
        else -> throw Exception("Unrecognized node $this")
    }
}
