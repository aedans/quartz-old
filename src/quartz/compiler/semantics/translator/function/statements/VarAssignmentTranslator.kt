package quartz.compiler.semantics.translator.function.statements

import quartz.compiler.semantics.translator.function.translate
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.syntax.tree.program.function.statement.VarAssignmentNode

/**
 * Created by Aedan Smith.
 */

fun VarAssignmentNode.translate(newStatements: MutableList<StatementNode>) {
    expression = expression.translate(newStatements)
}
