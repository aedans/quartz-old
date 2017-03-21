package quartz.compiler.semantics.translator.function.expressions

import quartz.compiler.semantics.translator.function.statements.translate
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.syntax.tree.program.function.expression.IdentifierNode
import quartz.compiler.syntax.tree.program.function.expression.IfExpressionNode
import quartz.compiler.syntax.tree.program.function.statement.IfStatementNode
import quartz.compiler.syntax.tree.program.function.statement.VarAssignmentNode
import quartz.compiler.syntax.tree.program.function.statement.VarDeclarationNode

/**
 * Created by Aedan Smith.
 */

fun IfExpressionNode.translate(newStatements: MutableList<StatementNode>): IdentifierNode {
    val tempVarName = "temp${hashCode()}"
    newStatements.add(VarDeclarationNode(tempVarName, type ?: throw Exception("Unknown type for $this"), true, null))
    val ifStatement = IfStatementNode(test)
    ifStatement.trueStatements.add(VarAssignmentNode(tempVarName, ifTrue))
    ifStatement.falseStatements.add(VarAssignmentNode(tempVarName, ifFalse))
    ifStatement.translate(newStatements)
    newStatements.add(ifStatement)
    return IdentifierNode(tempVarName)
}
