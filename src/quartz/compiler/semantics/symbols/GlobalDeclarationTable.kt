package quartz.compiler.semantics.symbols

import quartz.compiler.tree.GlobalDeclaration

/**
 * Created by Aedan Smith.
 */

interface GlobalDeclarationTable {
    fun getGlobalDeclaration(name: String): GlobalDeclaration?
}
