package quartz.compiler.semantics.contexts

import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.util.Context

/**
 * Created by Aedan Smith.
 */

data class ExternFunctionDeclarationContext(
        val externFunctionDeclaration: ExternFunctionDeclaration,
        val symbolContext: SymbolContext
) : Context<ExternFunctionDeclaration> {
    override val t
        get() = externFunctionDeclaration
}
