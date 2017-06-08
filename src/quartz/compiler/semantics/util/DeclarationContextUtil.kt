package quartz.compiler.semantics.util

import quartz.compiler.semantics.tables.DeclarationTable
import quartz.compiler.tree.Declaration

/**
 * Created by Aedan Smith.
 */

fun DeclarationTable.without(declarationName: String): DeclarationTable {
    return object : DeclarationTable {
        override fun getDeclaration(name: String): Declaration? {
            return if (declarationName == name) null else this@without.getDeclaration(name)
        }
    }
}
