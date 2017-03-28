package quartz.compiler.semantics

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.function.StatementNode
import quartz.compiler.syntax.tree.function.expression.*
import quartz.compiler.syntax.tree.function.statement.*
import quartz.compiler.visitor.program.function.visit
import quartz.compiler.visitor.visit

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.unwrapExpressions(): ProgramNode {
    return this.visit(FnDeclarationNode::unwrapExpressions)
}

private fun FnDeclarationNode.unwrapExpressions(): FnDeclarationNode {
    val newStatements = mutableListOf<StatementNode>()
    statements.forEach { newStatements.add(it.unwrapExpressions(newStatements)) }
    return FnDeclarationNode(name, args, returnType, newStatements)
}

private fun StatementNode.unwrapExpressions(newStatements: MutableList<StatementNode>): StatementNode {
    return this.visit(
            varDeclarationVisitor = {
                VarDeclarationNode(name, type, mutable, expression?.unwrap(newStatements))
            },
            returnVisitor = {
                ReturnNode(expressionNode.unwrap(newStatements))
            },
            ifStatementVisitor = {
                IfStatementNode(
                        test.unwrap(newStatements),
                        trueStatements.map { it.unwrapExpressions(newStatements) },
                        falseStatements.map { it.unwrapExpressions(newStatements) }
                )
            },
            whileLoopVisitor = {
                WhileLoopNode(test.unwrap(newStatements), statements.map { it.unwrapExpressions(newStatements) })
            },
            fnCallVisitor = {
                FnCallNode(expression.unwrap(newStatements), expressions.map { it.unwrap(newStatements) }, type)
            },
            varAssignmentVisitor = {
                VarAssignmentNode(name, expression.unwrap(newStatements))
            }
    )
}

private fun ExpressionNode.unwrap(newStatements: MutableList<StatementNode>): ExpressionNode {
    return this.visit(
            castVisitor = {
                CastNode(type, expression.unwrap(newStatements))
            },
            unaryOperatorVisitor = {
                UnaryOperatorNode(expression.unwrap(newStatements), id, type)
            },
            binaryOperatorVisitor = {
                BinaryOperatorNode(expr1.unwrap(newStatements), expr2.unwrap(newStatements), id, type)
            },
            fnCallVisitor = {
                FnCallNode(expression.unwrap(newStatements), expressions.map { it.unwrap(newStatements) }, type)
            },
            memberAccessVisitor = {
                MemberAccessNode(name, type, expression.unwrap(newStatements))
            },
            ifExpressionVisitor = {
                val tempVarName = "temp${hashCode()}"
                newStatements.add(VarDeclarationNode(tempVarName, type
                        ?: throw QuartzException("Unknown type for $this"), true, null))

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
    )
}
