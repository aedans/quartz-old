package quartz.compiler.semantics.translator.function.statements

import quartz.compiler.semantics.translator.function.translate
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.syntax.tree.program.function.statement.VarDeclarationNode

/**
 * Created by Aedan Smith.
 */

fun VarDeclarationNode.translate(newStatements: MutableList<StatementNode>) {
    if (expression != null) {
        expression = expression!!.translate(newStatements)
    }
}
