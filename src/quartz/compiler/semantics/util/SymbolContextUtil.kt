package quartz.compiler.semantics.util

import quartz.compiler.semantics.contexts.SymbolContext
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

fun SymbolContext.withVar(varName: String, type: Type): SymbolContext {
    return object : SymbolContext by this {
        override fun getVar(name: String): Type? {
            return if (varName == name) type else this@withVar.getVar(name)
        }
    }
}
