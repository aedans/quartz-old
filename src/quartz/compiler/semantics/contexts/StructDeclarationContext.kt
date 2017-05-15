package quartz.compiler.semantics.contexts

import quartz.compiler.tree.struct.StructDeclaration

/**
 * Created by Aedan Smith.
 */

data class StructDeclarationContext(
        val structDeclaration: StructDeclaration,
        val programContext: ProgramContext
)
