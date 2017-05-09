package quartz.compiler.semantics.symboltable

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

interface SymbolTable {
    operator fun plus(variable: Pair<String, Type>): SymbolTable

    fun getVar(name: String): Type?

    fun getType(name: String): Type?

    fun globalSymbolTable(): GlobalSymbolTable
}
