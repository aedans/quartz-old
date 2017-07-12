package quartz.compiler.semantics.tables

import quartz.compiler.tree.declarations.TypeDeclaration
import quartz.compiler.tree.declarations.VariableDeclaration
import quartz.compiler.tree.expression.LetExpression

/**
 * Created by Aedan Smith.
 */

data class LetExpressionSymbolTable(
        val symbolTable: SymbolTable,
        val letExpression: LetExpression
) : SymbolTable {
    override fun getVariableDeclaration(name: String): VariableDeclaration? {
        return if (name == letExpression.name) letExpression.declaration() else symbolTable.getVariableDeclaration(name)
    }

    override fun getTypeDeclaration(name: String): TypeDeclaration? {
        return symbolTable.getTypeDeclaration(name)
    }
}
