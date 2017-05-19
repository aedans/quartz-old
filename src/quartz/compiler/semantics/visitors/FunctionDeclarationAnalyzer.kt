package quartz.compiler.semantics.visitors

import quartz.compiler.semantics.contexts.FunctionDeclarationContext
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.util.visitors.functionDeclarationVisitor
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object FunctionDeclarationAnalyzer : Visitor<FunctionDeclarationContext> by visitor(
        {
            it.copy(symbolContext = it.symbolContext.copy(programContext = it.symbolContext.programContext.copy(
                    program = it.symbolContext.programContext.program + it.functionDeclaration)))
        },
        { functionDeclarationContext ->
            val (newFunction, newSymbolContext) = TypeAnalyzer.analyze(
                    functionDeclarationContext.functionDeclaration.function,
                    functionDeclarationContext.symbolContext
            )
            functionDeclarationContext.copy(
                    functionDeclaration = functionDeclarationContext.functionDeclaration.copy(function = newFunction),
                    symbolContext = newSymbolContext
            )
        },
        BlockAnalyzer.functionDeclarationVisitor(),
        {
            it.copy(symbolContext = it.symbolContext.copy(
                    programContext = it.symbolContext.programContext.programContext.copy(
                            program = it.symbolContext.programContext.program + it.functionDeclaration
                    ))
            )
        }
)
