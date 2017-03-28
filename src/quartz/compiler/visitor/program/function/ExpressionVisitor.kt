package quartz.compiler.visitor.program.function

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.syntax.tree.function.expression.*
import quartz.compiler.syntax.tree.function.statement.FnCallNode
import quartz.compiler.syntax.tree.misc.InlineCNode

/**
 * Created by Aedan Smith.
 */

fun ExpressionNode.visit(
        inlineCVisitor: InlineCNode.() -> ExpressionNode = { this },
        numberLiteralVisitor: NumberLiteralNode.() -> ExpressionNode = { this },
        stringLiteralVisitor: StringLiteralNode.() -> ExpressionNode = { this },
        identifierVisitor: IdentifierNode.() -> ExpressionNode = { this },
        castVisitor: CastNode.() -> ExpressionNode = { this },
        unaryOperatorVisitor: UnaryOperatorNode.() -> ExpressionNode = { this },
        binaryOperatorVisitor: BinaryOperatorNode.() -> ExpressionNode = { this },
        fnCallVisitor: FnCallNode.() -> ExpressionNode = { this },
        memberAccessVisitor: MemberAccessNode.() -> ExpressionNode = { this },
        ifExpressionVisitor: IfExpressionNode.() -> ExpressionNode = { this }
): ExpressionNode {
    return when (this) {
        is InlineCNode -> inlineCVisitor(this)
        is NumberLiteralNode -> numberLiteralVisitor(this)
        is StringLiteralNode -> stringLiteralVisitor(this)
        is IdentifierNode -> identifierVisitor(this)
        is CastNode -> castVisitor(this)
        is UnaryOperatorNode -> unaryOperatorVisitor(this)
        is BinaryOperatorNode -> binaryOperatorVisitor(this)
        is FnCallNode -> fnCallVisitor(this)
        is MemberAccessNode -> memberAccessVisitor(this)
        is IfExpressionNode -> ifExpressionVisitor(this)
        else -> throw QuartzException("Unrecognized node $this")
    }
}
