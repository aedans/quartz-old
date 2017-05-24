package quartz.compiler.semantics.visitors

import quartz.compiler.semantics.contexts.StructDeclarationContext
import quartz.compiler.semantics.contexts.TypeContext
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object StructDeclarationAnalyzer {
    inline fun analyzeTypes(
            typeAnalyzer: Visitor<TypeContext>,
            context: StructDeclarationContext
    ): StructDeclarationContext {
        var newStructDeclarationContext = context
        val structDeclaration = context.structDeclaration

        val newStructDeclaration = structDeclaration.copy(
                members = structDeclaration.members.mapValues {
                    val (type, newSymbolContext) = typeAnalyzer(TypeContext(
                            it.value.type,
                            newStructDeclarationContext
                    ))
                    newStructDeclarationContext = newSymbolContext as StructDeclarationContext
                    it.value.copy(type = type)
                }
        )

        return newStructDeclarationContext.copy(structDeclaration = newStructDeclaration)
    }

    fun resolveGenerics(context: StructDeclarationContext): StructDeclarationContext {
        return context.copy(
                structDeclaration = context.structDeclaration.copy(
                        name = context.structDeclaration.name +
                                context.genericArguments.joinToString(separator = "") { "_${it.descriptiveString}" },
                        generics = emptyList()
                ),
                genericArguments = emptyList()
        )
    }

    fun addToProgram(context: StructDeclarationContext): StructDeclarationContext {
        return context.copy(
                programContext = context.programContext.copy(
                        program = context.programContext.program + context.structDeclaration
                )
        )
    }
}
