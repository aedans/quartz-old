package quartz.compiler.semantics.visitors

import quartz.compiler.semantics.contexts.ExternFunctionDeclarationContext
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object ExternFunctionDeclarationAnalyzer : Visitor<ExternFunctionDeclarationContext> {
    override fun invoke(externFunctionDeclarationContext: ExternFunctionDeclarationContext): ExternFunctionDeclarationContext {
        val (externFunctionDeclaration, symbolContext) = externFunctionDeclarationContext
        val (newFunction, newSymbolContext) = TypeAnalyzer.analyze(
                externFunctionDeclaration.function,
                symbolContext
        )

        return ExternFunctionDeclarationContext(externFunctionDeclaration.copy(function = newFunction), newSymbolContext)
    }
}
