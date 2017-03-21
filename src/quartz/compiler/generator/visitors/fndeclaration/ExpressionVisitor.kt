package quartz.compiler.generator.visitors.fndeclaration

import quartz.compiler.generator.visitors.fndeclaration.expression.visit
import quartz.compiler.generator.visitors.fndeclaration.statement.visit
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.expression.*
import quartz.compiler.syntax.tree.program.function.statement.FnCallNode
import quartz.compiler.syntax.tree.program.misc.InlineCNode

/**
 * Created by Aedan Smith.
 */

fun ExpressionNode.visit(string: StringBuilder) {
    when (this) {
        is CastNode -> visit(string)
        is IdentifierNode -> visit(string)
        is NumberLiteralNode -> visit(string)
        is UnaryOperatorNode -> visit(string)
        is StringLiteralNode -> visit(string)
        is BinaryOperatorNode -> visit(string)
        is InlineCNode -> visit(string)
        is FnCallNode -> visit(string)
        is MemberAccessNode -> visit(string)
        else -> throw Exception("Unrecognized node $this")
    }
}