package quartz.compiler.generator.semantics

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.function.StatementNode
import quartz.compiler.syntax.tree.function.expression.*
import quartz.compiler.syntax.tree.function.statement.*
import quartz.compiler.syntax.tree.misc.InlineCNode

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.unwrapExpressions(): ProgramNode {
    return this.mapFnDeclarations(FnDeclarationNode::unwrapExpressions)
}

private fun FnDeclarationNode.unwrapExpressions(): FnDeclarationNode {
    val newStatements = mutableListOf<StatementNode>()
    statements.forEach { newStatements.add(it.unwrapExpressions(newStatements)) }
    return FnDeclarationNode(name, argNames, function, newStatements)
}

private fun StatementNode.unwrapExpressions(newStatements: MutableList<StatementNode>): StatementNode {
    return when (this) {
        is InlineCNode -> this
        is VarDeclarationNode -> VarDeclarationNode(name, expression?.unwrap(newStatements), type, mutable)
        is ReturnNode -> ReturnNode(expression.unwrap(newStatements))
        is VarAssignmentNode -> VarAssignmentNode(name, expression.unwrap(newStatements))
        is IfStatementNode -> IfStatementNode(
                test.unwrap(newStatements),
                trueStatements.map { it.unwrapExpressions(newStatements) },
                falseStatements.map { it.unwrapExpressions(newStatements) }
        )
        is WhileLoopNode -> WhileLoopNode(
                test.unwrap(newStatements),
                statements.map { it.unwrapExpressions(newStatements) }
        )
        is FnCallNode -> FnCallNode(
                expression.unwrap(newStatements),
                expressions.map { it.unwrap(newStatements) },
                type
        )
        else -> throw QuartzException("Unrecognized node $this")
    }
}

private fun ExpressionNode.unwrap(newStatements: MutableList<StatementNode>): ExpressionNode {
    return when (this) {
        is InlineCNode -> this
        is NumberLiteralNode -> this
        is StringLiteralNode -> this
        is IdentifierNode -> this
        is CastNode -> CastNode(expression.unwrap(newStatements), type)
        is UnaryOperatorNode -> UnaryOperatorNode(expression.unwrap(newStatements), id, type)
        is BinaryOperatorNode -> BinaryOperatorNode(expr1.unwrap(newStatements), expr2.unwrap(newStatements), id, type)
        is FnCallNode -> FnCallNode(expression.unwrap(newStatements), expressions.map { it.unwrap(newStatements) }, type)
        is MemberAccessNode -> MemberAccessNode(name, expression.unwrap(newStatements), type)
        is IfExpressionNode -> {
            val tempVarName = "temp${hashCode()}"
            newStatements.add(VarDeclarationNode(tempVarName, null, type
                    ?: throw QuartzException("Unknown aliasedType for $this"), true))

            val trueStatements = mutableListOf<StatementNode>()
            trueStatements.add(VarAssignmentNode(tempVarName, ifTrue.unwrap(trueStatements)))

            val falseStatements = mutableListOf<StatementNode>()
            falseStatements.add(VarAssignmentNode(tempVarName, ifFalse.unwrap(falseStatements)))

            newStatements.add(IfStatementNode(
                    test,
                    trueStatements,
                    falseStatements
            ))
            IdentifierNode(tempVarName, type)
        }
        else -> throw QuartzException("Unrecognized node $this")
    }
}
