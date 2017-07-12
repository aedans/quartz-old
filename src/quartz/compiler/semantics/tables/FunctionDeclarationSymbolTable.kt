package quartz.compiler.semantics.tables

import quartz.compiler.tree.declarations.TypeDeclaration
import quartz.compiler.tree.declarations.VariableDeclaration
import quartz.compiler.tree.declarations.FunctionDeclaration

/**
 * Created by Aedan Smith.
 */

data class FunctionDeclarationSymbolTable(
        val symbolTable: SymbolTable,
        val functionDeclaration: FunctionDeclaration
) : SymbolTable {
    override fun getVariableDeclaration(name: String): VariableDeclaration? {
        return functionDeclaration.argDeclarations
                .firstOrNull { it.name == name }
                ?: symbolTable.getVariableDeclaration(name)
    }

    override fun getTypeDeclaration(name: String): TypeDeclaration? {
        return symbolTable.getTypeDeclaration(name)
    }
}
