package quartz.compiler.semantics.visitors

import quartz.compiler.semantics.contexts.FunctionDeclarationContext
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.util.visitors.functionDeclarationVisitor
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object FunctionDeclarationAnalyzer : Visitor<FunctionDeclarationContext> by visitor(
        { functionDeclarationContext ->
            val (newFunction, newFunctionDeclarationContext) = TypeAnalyzer.analyze(
                    functionDeclarationContext.functionDeclaration.function,
                    functionDeclarationContext
            )

            newFunctionDeclarationContext as FunctionDeclarationContext

            newFunctionDeclarationContext.copy(
                    functionDeclaration = newFunctionDeclarationContext.functionDeclaration.copy(
                            function = newFunction
                    )
            )
        },
        BlockAnalyzer.functionDeclarationVisitor(),
        {
            it.copy(
                    functionDeclaration = it.functionDeclaration.copy(
                            name = it.functionDeclaration.name +
                                    it.genericArguments.joinToString(separator = "") { "_${it.descriptiveString}" },
                            generics = emptyList()
                    ),
                    genericArguments = emptyList()
            )
        },
        {
            it.copy(symbolContext = it.symbolContext.copy(
                    programContext = it.symbolContext.programContext.programContext.copy(
                            program = it.symbolContext.programContext.program + it.functionDeclaration
                    )
            ))
        }
)
