package quartz.compiler.semantics.contexts

import quartz.compiler.tree.Declaration

/**
 * Created by Aedan Smith.
 */

interface DeclarationContext {
    fun getDeclaration(name: String): Declaration?
}
