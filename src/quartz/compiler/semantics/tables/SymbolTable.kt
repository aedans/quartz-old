package quartz.compiler.semantics.tables

import quartz.compiler.tree.Declaration
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

interface SymbolTable {
    fun getVar(name: String): Type?

    fun getType(name: String): Type?

    fun getDeclaration(name: String): Declaration?
}
