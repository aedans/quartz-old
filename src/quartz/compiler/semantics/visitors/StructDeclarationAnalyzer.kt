package quartz.compiler.semantics.visitors

import quartz.compiler.semantics.contexts.StructDeclarationContext
import quartz.compiler.semantics.contexts.TypeContext
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object StructDeclarationAnalyzer : Visitor<StructDeclarationContext> {
    override fun invoke(structDeclarationContext: StructDeclarationContext): StructDeclarationContext {
        var symbolContext = structDeclarationContext.symbolContext
        val structDeclaration = structDeclarationContext.structDeclaration

        val newStructDeclaration = structDeclaration.copy(
                members = structDeclaration.members.mapValues {
                    val (type, newSymbolContext) = TypeAnalyzer(TypeContext(
                            it.value.type,
                            symbolContext
                    ))
                    symbolContext = newSymbolContext
                    it.value.copy(type = type)
                }
        )

        symbolContext = symbolContext.copy(programContext = symbolContext.programContext.copy(
                program = symbolContext.programContext.program + newStructDeclaration
        ))

        return StructDeclarationContext(newStructDeclaration, symbolContext)
    }
}
