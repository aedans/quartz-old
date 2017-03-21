package quartz.compiler.semantics.translator.function

import quartz.compiler.semantics.translator.translateAll
import quartz.compiler.syntax.tree.program.function.FnDeclarationNode

/**
 * Created by Aedan Smith.
 */

fun FnDeclarationNode.translate() {
    statements = statements.translateAll()
}
