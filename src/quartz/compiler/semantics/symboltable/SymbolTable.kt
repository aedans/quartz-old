package quartz.compiler.semantics.symboltable

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

interface SymbolTable {
    fun add(name: String, type: Type)

    operator fun get(name: String): Type?

    fun getGlobalSymbolTable(): GlobalSymbolTable
}
