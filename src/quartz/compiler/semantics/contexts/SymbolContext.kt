package quartz.compiler.semantics.contexts

import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

interface SymbolContext {
    val programContext: ProgramContext

    fun getVar(name: String): Type?
    fun addVar(name: String, type: Type): SymbolContext
    fun getType(name: String): Type?

    fun getFunctionDeclaration(name: String): FunctionDeclaration?

    fun copy(programContext: ProgramContext = this.programContext): SymbolContext
}
