package quartz.compiler.semantics.translator.function.statements

import quartz.compiler.semantics.translator.function.translate
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.syntax.tree.program.function.statement.ReturnNode

/**
 * Created by Aedan Smith.
 */

fun ReturnNode.translate(newStatements: MutableList<StatementNode>) {
    expressionNode = expressionNode.translate(newStatements)
}
