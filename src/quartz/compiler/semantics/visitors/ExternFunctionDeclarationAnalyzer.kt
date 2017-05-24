package quartz.compiler.semantics.visitors

import quartz.compiler.semantics.contexts.ExternFunctionDeclarationContext
import quartz.compiler.semantics.contexts.TypeContext
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object ExternFunctionDeclarationAnalyzer {
    inline fun analyzeTypes(
            crossinline typeAnalyzer: Visitor<TypeContext>,
            context: ExternFunctionDeclarationContext
    ): ExternFunctionDeclarationContext {
        val (externFunctionDeclaration, symbolContext) = context
        val (newFunction, newSymbolContext) = TypeAnalyzer.analyze(
                typeAnalyzer,
                externFunctionDeclaration.function,
                symbolContext
        )

        return ExternFunctionDeclarationContext(externFunctionDeclaration.copy(function = newFunction), newSymbolContext)
    }

    fun addToProgram(context: ExternFunctionDeclarationContext): ExternFunctionDeclarationContext {
        return context.copy(symbolContext = context.symbolContext.copy(
                programContext = context.symbolContext.programContext.programContext.copy(
                        program = context.symbolContext.programContext.program + context.externFunctionDeclaration
                ))
        )
    }
}
