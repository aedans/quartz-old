package quartz.compiler.semantics.tables

import quartz.compiler.tree.declarations.TypeDeclaration
import quartz.compiler.tree.declarations.VariableDeclaration

/**
 * Created by Aedan Smith.
 */

interface SymbolTable {
    fun getVariableDeclaration(name: String): VariableDeclaration?

    fun getTypeDeclaration(name: String): TypeDeclaration?
}
