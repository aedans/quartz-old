package quartz.compiler.semantics.tables

import quartz.compiler.tree.Declaration
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class FunctionDeclarationSymbolTable(
        val symbolTable: SymbolTable,
        val functionDeclaration: FunctionDeclaration
) : SymbolTable {
    override fun getType(name: String): Type? {
        return symbolTable.getType(name)
    }

    override fun getVar(name: String): Type? {
        return functionDeclaration.args
                .firstOrNull { it.first == name }?.second
                ?: symbolTable.getVar(name)
    }

    override fun getDeclaration(name: String): Declaration? {
        return if (name == functionDeclaration.name) functionDeclaration else symbolTable.getDeclaration(name)
    }
}
