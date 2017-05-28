package quartz.compiler.semantics.visitors

import quartz.compiler.semantics.symbols.SymbolTable
import quartz.compiler.semantics.types.type
import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.tree.Program
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

object ProgramAnalyzer {
    fun symbolTable(program: Program): SymbolTable {
        return object : SymbolTable {
            override fun getGlobalDeclaration(name: String): GlobalDeclaration? {
                return program.functionDeclarations[name]
                        ?: program.externFunctionDeclarations[name]
                        ?: program.typealiasDeclarations[name]
            }

            override fun getType(name: String): Type? {
                return program.typealiasDeclarations[name]?.aliasedType
            }

            override fun getVar(name: String): Type? {
                return program.functionDeclarations[name]?.type()
                        ?: program.externFunctionDeclarations[name]?.type()
            }
        }
    }
}
