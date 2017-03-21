package quartz.compiler.semantics.translator

import quartz.compiler.semantics.translator.function.translate
import quartz.compiler.syntax.tree.ProgramNode

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.translate() {
    fnDeclarations.forEach { it.translate() }
}
