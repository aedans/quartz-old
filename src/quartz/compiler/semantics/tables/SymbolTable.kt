package quartz.compiler.semantics.tables

import quartz.compiler.tree.TypeDeclaration
import quartz.compiler.tree.VariableDeclaration

/**
 * Created by Aedan Smith.
 */

interface SymbolTable {
    fun getVariableDeclaration(name: String): VariableDeclaration?

    fun getTypeDeclaration(name: String): TypeDeclaration?
}
