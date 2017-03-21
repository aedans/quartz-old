package quartz.compiler.semantics.translator

import quartz.compiler.semantics.translator.function.translate
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.StatementNode

/**
 * Created by Aedan Smith.
 */

fun Iterable<StatementNode>.translateAll(): MutableList<StatementNode> {
    val newStatements = mutableListOf<StatementNode>()
    forEach { it.translate(newStatements) }
    return newStatements
}

fun Iterable<ExpressionNode>.translateEach(newStatements: MutableList<StatementNode>): MutableList<ExpressionNode> {
    return map { it.translate(newStatements) }.toMutableList()
}
