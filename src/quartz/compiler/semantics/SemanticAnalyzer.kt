package quartz.compiler.semantics

import quartz.compiler.syntax.tree.ProgramNode

/**
 * Created by Aedan Smith.
 */

typealias SemanticAnalyzer = (ProgramNode) -> Unit

fun Iterable<SemanticAnalyzer>.analyze(programNode: ProgramNode) {
    this.forEach { it(programNode) }
}
