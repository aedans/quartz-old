package quartz.compiler.semantics.util

import quartz.compiler.semantics.contexts.DeclarationContext
import quartz.compiler.tree.Declaration

/**
 * Created by Aedan Smith.
 */

fun DeclarationContext.without(declarationName: String): DeclarationContext {
    return object : DeclarationContext {
        override fun getDeclaration(name: String): Declaration? {
            return if (declarationName == name) null else this@without.getDeclaration(name)
        }
    }
}
