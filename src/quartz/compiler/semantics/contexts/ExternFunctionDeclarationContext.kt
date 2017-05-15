package quartz.compiler.semantics.contexts

import quartz.compiler.tree.misc.ExternFunctionDeclaration

/**
 * Created by Aedan Smith.
 */

data class ExternFunctionDeclarationContext(
        val externFunctionDeclaration: ExternFunctionDeclaration,
        val programContext: ProgramContext
)
