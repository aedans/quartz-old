package quartz.compiler.semantics.util

import quartz.compiler.semantics.symbols.SymbolTable
import quartz.compiler.semantics.types.type
import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.tree.Program
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

fun SymbolTable.withVar(varName: String, type: Type): SymbolTable {
    return object : SymbolTable by this {
        override fun getVar(name: String): Type? {
            return if (name == varName) type else this@withVar.getVar(name)
        }
    }
}

fun Program.symbolTable(): SymbolTable {
    val program = this
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
