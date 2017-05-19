package quartz.compiler.semantics.contexts

import quartz.compiler.errors.QuartzException
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class FunctionDeclarationContext(
        val functionDeclaration: FunctionDeclaration,
        val symbolContext: SymbolContext
) : SymbolContext {
    override val programContext
        get() = symbolContext.programContext

    override fun getVar(name: String): Type? {
        return functionDeclaration.argsWithNames?.firstOrNull { it.first == name }?.second
                ?: programContext.getVar(name)
    }

    override fun addVar(name: String, type: Type): SymbolContext {
        throw QuartzException("Could not add variable to function declaration")
    }

    override fun getType(name: String): Type? {
        return programContext.getType(name)
    }

    override fun copy(programContext: ProgramContext): SymbolContext {
        return copy(functionDeclaration, symbolContext.copy(programContext = programContext))
    }
}
