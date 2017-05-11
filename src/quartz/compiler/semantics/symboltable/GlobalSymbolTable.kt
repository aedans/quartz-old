package quartz.compiler.semantics.symboltable

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.types.type
import quartz.compiler.tree.Program
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class GlobalSymbolTable(val program: Program) : SymbolTable {
    override operator fun plus(variable: Pair<String, Type>): Nothing {
        throw QuartzException("Could not add variable to global symbol table")
    }

    override fun getVar(name: String): Type? {
        return program.functionDeclarations[name]?.type()
                ?: program.externFunctionDeclarations[name]?.type()
    }

    override fun getType(name: String): Type? {
        return program.structDeclarations[name]?.type()
                ?: program.typealiasDeclarations[name]?.aliasedType
    }

    override fun globalSymbolTable(): GlobalSymbolTable {
        return this
    }

    override fun toString(): String {
        return "GlobalSymbolTable"
    }
}
