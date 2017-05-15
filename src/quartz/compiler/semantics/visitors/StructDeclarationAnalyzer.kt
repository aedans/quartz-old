package quartz.compiler.semantics.visitors

import quartz.compiler.semantics.contexts.StructDeclarationContext
import quartz.compiler.semantics.contexts.TypeContext
import quartz.compiler.semantics.types.type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object StructDeclarationAnalyzer : Visitor<StructDeclarationContext> {
    override fun invoke(structDeclarationContext: StructDeclarationContext): StructDeclarationContext {
        var programContext = structDeclarationContext.programContext
        val structDeclaration = structDeclarationContext.structDeclaration

        val newStructDeclaration = structDeclaration.copy(
                members = structDeclaration.members.mapValues {
                    val (type, newProgramContext) = TypeAnalyzer(TypeContext(
                            it.value.type,
                            programContext
                    ))
                    programContext = newProgramContext
                    it.value.copy(type = type)
                }
        )

        programContext = programContext.copy(program = programContext.program + newStructDeclaration)

        return StructDeclarationContext(newStructDeclaration, programContext)
    }
}
