package quartz.compiler.semantics.symboltable

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

interface SymbolTable {
    fun getVar(name: String): Type?

    fun addVar(name: String, type: Type)

    fun getGlobalSymbolTable(): GlobalSymbolTable
}
