package quartz.compiler.semantics.visitors

import quartz.compiler.semantics.contexts.ExternFunctionDeclarationContext
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object ExternFunctionDeclarationAnalyzer : Visitor<ExternFunctionDeclarationContext> {
    override fun invoke(externFunctionDeclarationContext: ExternFunctionDeclarationContext): ExternFunctionDeclarationContext {
        val (externFunctionDeclaration, programContext) = externFunctionDeclarationContext
        val (newFunction, newProgramContext) = TypeAnalyzer.analyze(
                externFunctionDeclaration.function,
                programContext
        )

        return ExternFunctionDeclarationContext(externFunctionDeclaration.copy(function = newFunction), newProgramContext)
    }
}
