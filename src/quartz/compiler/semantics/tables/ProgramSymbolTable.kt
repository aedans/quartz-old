package quartz.compiler.semantics.tables

import quartz.compiler.semantics.types.type
import quartz.compiler.tree.Declaration
import quartz.compiler.tree.Program
import quartz.compiler.tree.declarations.ExternFunctionDeclaration
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.declarations.InlineC
import quartz.compiler.tree.declarations.TypealiasDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.tree.util.toMap

/**
 * Created by Aedan Smith.
 */

data class ProgramSymbolTable(
        val functionDeclarations: Map<String, FunctionDeclaration>,
        val externFunctionDeclarations: Map<String, ExternFunctionDeclaration>,
        val typealiasDeclarations: Map<String, TypealiasDeclaration>,
        val inlineCDeclarations: List<InlineC>
) : SymbolTable {
    constructor(program: Program) : this(
            program.filterIsInstance(FunctionDeclaration::class.java).toMap(),
            program.filterIsInstance(ExternFunctionDeclaration::class.java).toMap(),
            program.filterIsInstance(TypealiasDeclaration::class.java).toMap(),
            program.filterIsInstance(InlineC::class.java)
    )

    override fun getType(name: String): Type? {
        return typealiasDeclarations[name]?.aliasedType
    }

    override fun getVar(name: String): Type? {
        return functionDeclarations[name]?.type()
                ?: externFunctionDeclarations[name]?.type()
    }

    override fun getDeclaration(name: String): Declaration? {
        return functionDeclarations[name]
                ?: externFunctionDeclarations[name]
                ?: typealiasDeclarations[name]
    }
}
