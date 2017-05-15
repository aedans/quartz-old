package quartz.compiler.semantics.contexts

import quartz.compiler.errors.QuartzException
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class FunctionDeclarationContext(
        val functionDeclaration: FunctionDeclaration,
        override val programContext: ProgramContext
) : SymbolContext {
    override fun getVar(name: String): Type? {
        return functionDeclaration.argsWithNames?.firstOrNull { it.first == name }?.second
                ?: programContext.getVar(name)
    }

    override fun addVar(name: String, type: Type): SymbolContext {
        throw QuartzException("Could not add variable to function declaration")
    }

    override fun copy(programContext: ProgramContext): SymbolContext {
        return copy(functionDeclaration, programContext = programContext)
    }
}
