package quartz.compiler.semantics.translator.function.statements

import quartz.compiler.semantics.translator.translateEach
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.syntax.tree.program.function.statement.FnCallNode

/**
 * Created by Aedan Smith.
 */

fun FnCallNode.translate(newStatements: MutableList<StatementNode>) {
    expressions = expressions.translateEach(newStatements)
}
