package quartz.compiler.semantics.contexts

import quartz.compiler.errors.QuartzException
import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Context

/**
 * Created by Aedan Smith.
 */

data class StructDeclarationContext(
        val structDeclaration: StructDeclaration,
        val symbolContext: SymbolContext,
        val genericArguments: List<Type>
) : Context<StructDeclaration>, SymbolContext by symbolContext {
    override val t
            get() = structDeclaration
    val genericArgumentMap =
            if (structDeclaration.generics.size != genericArguments.size)
                throw QuartzException("Incorrect number of generic arguments for ${structDeclaration.name}")
            else
                structDeclaration.generics.zip(genericArguments).toMap()

    override fun getType(name: String): Type? {
        return genericArgumentMap[name] ?: symbolContext.getType(name)
    }

    override fun copy(programContext: ProgramContext): StructDeclarationContext {
        return copy(symbolContext = symbolContext.copy(programContext = programContext))
    }
}
