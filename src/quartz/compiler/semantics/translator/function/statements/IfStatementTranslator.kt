package quartz.compiler.semantics.translator.function.statements

import quartz.compiler.semantics.translator.function.translate
import quartz.compiler.semantics.translator.translateAll
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.syntax.tree.program.function.statement.IfStatementNode

/**
 * Created by Aedan Smith.
 */

fun IfStatementNode.translate(newStatements: MutableList<StatementNode>) {
    test = test.translate(newStatements)
    trueStatements = trueStatements.translateAll()
    falseStatements = falseStatements.translateAll()
}
