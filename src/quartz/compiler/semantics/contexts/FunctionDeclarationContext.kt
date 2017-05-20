package quartz.compiler.semantics.contexts

import quartz.compiler.errors.QuartzException
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class FunctionDeclarationContext(
        val functionDeclaration: FunctionDeclaration,
        val symbolContext: SymbolContext,
        val genericArguments: List<Type>
) : SymbolContext {
    override val programContext
        get() = symbolContext.programContext

    val genericArgumentMap =
            if (functionDeclaration.generics.size != genericArguments.size)
                throw QuartzException("Incorrect number of generic arguments for ${functionDeclaration.name}")
            else
                functionDeclaration.generics.zip(genericArguments).toMap()

    override fun getVar(name: String): Type? {
        return functionDeclaration.argsWithNames?.firstOrNull { it.first == name }?.second
                ?: programContext.getVar(name)
    }

    override fun addVar(name: String, type: Type): SymbolContext {
        throw QuartzException("Could not add variable to function declaration")
    }

    override fun getType(name: String): Type? {
        return genericArgumentMap[name] ?: programContext.getType(name)
    }

    override fun getFunctionDeclaration(name: String): FunctionDeclaration? {
        return if (name == functionDeclaration.name) functionDeclaration else symbolContext.getFunctionDeclaration(name)
    }

    override fun copy(programContext: ProgramContext): SymbolContext {
        return copy(symbolContext = symbolContext.copy(programContext = programContext))
    }
}
