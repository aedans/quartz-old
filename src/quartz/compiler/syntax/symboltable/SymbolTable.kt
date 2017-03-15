package quartz.compiler.syntax.symboltable

import quartz.compiler.util.Variable

/**
 * Created by Aedan Smith.
 */

interface SymbolTable {
    fun add(name: String, variable: Variable)

    operator fun get(name: String): Variable

    fun getGlobalSymbolTable(): GlobalSymbolTable
}
