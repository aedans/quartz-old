package quartz.compiler.semantics.contexts

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

interface SymbolContext {
    val programContext: ProgramContext

    fun getVar(name: String): Type?
    fun addVar(name: String, type: Type): SymbolContext

    fun copy(programContext: ProgramContext = this.programContext): SymbolContext
}
