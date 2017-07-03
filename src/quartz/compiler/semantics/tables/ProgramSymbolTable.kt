package quartz.compiler.semantics.tables

import quartz.compiler.tree.Program
import quartz.compiler.tree.TypeDeclaration
import quartz.compiler.tree.VariableDeclaration
import quartz.compiler.tree.declarations.ExternFunctionDeclaration
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.declarations.InlineC
import quartz.compiler.tree.declarations.TypealiasDeclaration
import quartz.compiler.tree.util.toMap

/**
 * Created by Aedan Smith.
 */

data class ProgramSymbolTable(
        val functionDeclarations: Map<String, FunctionDeclaration>,
        val externFunctionDeclarations: Map<String, ExternFunctionDeclaration>,
        val typealiasDeclarations: Map<String, TypealiasDeclaration>,
        val inlineC: List<InlineC>
) : SymbolTable {
    constructor(program: Program) : this(
            program.filterIsInstance<FunctionDeclaration>().toMap(),
            program.filterIsInstance<ExternFunctionDeclaration>().toMap(),
            program.filterIsInstance<TypealiasDeclaration>().toMap(),
            program.filterIsInstance<InlineC>()
    )

    override fun getVariableDeclaration(name: String): VariableDeclaration? {
        return functionDeclarations[name]
                ?: externFunctionDeclarations[name]
    }

    override fun getTypeDeclaration(name: String): TypeDeclaration? {
        return typealiasDeclarations[name]
    }
}
