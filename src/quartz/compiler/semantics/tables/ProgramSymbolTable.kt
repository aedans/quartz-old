package quartz.compiler.semantics.tables

import quartz.compiler.tree.Program
import quartz.compiler.tree.declarations.TypeDeclaration
import quartz.compiler.tree.declarations.VariableDeclaration
import quartz.compiler.tree.declarations.InlineC
import quartz.compiler.tree.util.toMap

/**
 * Created by Aedan Smith.
 */

data class ProgramSymbolTable(
        val variableDeclarations: Map<String, VariableDeclaration>,
        val typeDeclarations: Map<String, TypeDeclaration>,
        val inlineC: List<InlineC>
) : SymbolTable {
    constructor(program: Program) : this(
            program.filterIsInstance<VariableDeclaration>().toMap(),
            program.filterIsInstance<TypeDeclaration>().toMap(),
            program.filterIsInstance<InlineC>()
    )

    override fun getVariableDeclaration(name: String): VariableDeclaration? {
        return variableDeclarations[name]
    }

    override fun getTypeDeclaration(name: String): TypeDeclaration? {
        return typeDeclarations[name]
    }
}
