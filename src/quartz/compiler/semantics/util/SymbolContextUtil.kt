package quartz.compiler.semantics.util

import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

fun SymbolTable.withVar(varName: String, type: Type): SymbolTable {
    return object : SymbolTable by this {
        override fun getVar(name: String): Type? {
            return if (varName == name) type else this@withVar.getVar(name)
        }
    }
}
