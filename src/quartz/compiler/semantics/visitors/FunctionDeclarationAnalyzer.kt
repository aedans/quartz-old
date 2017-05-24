package quartz.compiler.semantics.visitors

import quartz.compiler.semantics.contexts.FunctionDeclarationContext
import quartz.compiler.semantics.contexts.TypeContext
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object FunctionDeclarationAnalyzer {
    inline fun analyzeTypes(
            crossinline typeAnalyzer: Visitor<TypeContext>,
            context: FunctionDeclarationContext
    ): FunctionDeclarationContext {
        val (newFunction, newFunctionDeclarationContext) = TypeAnalyzer.analyze(
                typeAnalyzer,
                context.functionDeclaration.function,
                context
        )

        newFunctionDeclarationContext as FunctionDeclarationContext

        return newFunctionDeclarationContext.copy(
                functionDeclaration = newFunctionDeclarationContext.functionDeclaration.copy(
                        function = newFunction
                )
        )
    }

    fun resolveGenerics(context: FunctionDeclarationContext): FunctionDeclarationContext {
        return context.copy(
                functionDeclaration = context.functionDeclaration.copy(
                        name = context.functionDeclaration.name +
                                context.genericArguments.joinToString(separator = "") { "_${it.descriptiveString}" },
                        generics = emptyList()
                ),
                genericArguments = emptyList()
        )
    }

    fun addToProgram(context: FunctionDeclarationContext): FunctionDeclarationContext {
        return context.copy(symbolContext = context.symbolContext.copy(
                programContext = context.symbolContext.programContext.programContext.copy(
                        program = context.symbolContext.programContext.program + context.functionDeclaration
                )
        ))
    }
}
