package quartz.compiler.semantics.visitors

import quartz.compiler.semantics.contexts.ExternFunctionDeclarationContext
import quartz.compiler.semantics.util.visitor
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object ExternFunctionDeclarationAnalyzer : Visitor<ExternFunctionDeclarationContext> by visitor(
        { (externFunctionDeclaration, symbolContext) ->
            val (newFunction, newSymbolContext) = TypeAnalyzer.analyze(
                    externFunctionDeclaration.function,
                    symbolContext
            )

            ExternFunctionDeclarationContext(externFunctionDeclaration.copy(function = newFunction), newSymbolContext)
        },
        {
            it.copy(symbolContext = it.symbolContext.copy(
                    programContext = it.symbolContext.programContext.programContext.copy(
                            program = it.symbolContext.programContext.program + it.externFunctionDeclaration
                    ))
            )
        }

)
