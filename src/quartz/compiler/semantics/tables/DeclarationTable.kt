package quartz.compiler.semantics.tables

import quartz.compiler.tree.Declaration

/**
 * Created by Aedan Smith.
 */

interface DeclarationTable {
    fun getDeclaration(name: String): Declaration?
}
