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
            val (newFunction, newSymbolContext) = TypeAnalyzer.analyze(
                    it.functionDeclaration.function,
                    it.symbolContext
            )
            it.copy(
                    functionDeclaration = it.functionDeclaration.copy(function = newFunction),
                    symbolContext = newSymbolContext
            )
        },
        BlockAnalyzer.functionDeclarationVisitor()
)
