package quartz.compiler.semantics.visitors

import quartz.compiler.semantics.contexts.StructDeclarationContext
import quartz.compiler.semantics.contexts.TypeContext
import quartz.compiler.semantics.util.visitor
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object StructDeclarationAnalyzer : Visitor<StructDeclarationContext> by visitor(
        { structDeclarationContext ->
            var newStructDeclarationContext = structDeclarationContext
            val structDeclaration = structDeclarationContext.structDeclaration

            val newStructDeclaration = structDeclaration.copy(
                    members = structDeclaration.members.mapValues {
                        val (type, newSymbolContext) = TypeAnalyzer(TypeContext(
                                it.value.type,
                                newStructDeclarationContext
                        ))
                        newStructDeclarationContext = newSymbolContext as StructDeclarationContext
                        it.value.copy(type = type)
                    }
            )

            newStructDeclarationContext.copy(structDeclaration = newStructDeclaration)
        },
        {
            it.copy(
                    structDeclaration = it.structDeclaration.copy(
                            name = it.structDeclaration.name +
                                    it.genericArguments.joinToString(separator = "") { "_${it.descriptiveString}" },
                            generics = emptyList()
                    ),
                    genericArguments = emptyList()
            )
        },
        {
            it.copy(programContext = it.programContext.copy(program = it.programContext.program + it.structDeclaration))
        }
)
