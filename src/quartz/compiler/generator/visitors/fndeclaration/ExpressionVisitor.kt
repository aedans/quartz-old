package quartz.compiler.generator.visitors.fndeclaration

import quartz.compiler.generator.visitors.fndeclaration.expression.visit
import quartz.compiler.generator.visitors.fndeclaration.statement.visit
import quartz.compiler.syntax.tree.program.InlineCNode
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.expression.*
import quartz.compiler.syntax.tree.program.function.statement.FnCallNode

/**
 * Created by Aedan Smith.
 */

fun ExpressionNode.visit(string: StringBuilder) {
    when (this) {
        is CastNode -> visit(string)
        is IdentifierNode -> visit(string)
        is NumberLiteralNode -> visit(string)
        is OneArgOperatorNode -> visit(string)
        is StringLiteralNode -> visit(string)
        is TwoArgOperatorNode -> visit(string)
        is InlineCNode -> visit(string)
        is FnCallNode -> visit(string)
        else -> throw Exception("Unrecognized node $this")
    }
}