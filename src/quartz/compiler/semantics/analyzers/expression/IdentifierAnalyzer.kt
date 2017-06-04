package quartz.compiler.semantics.analyzers.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.contexts.SymbolContext
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

object IdentifierAnalyzer {
    inline fun analyzeType(
            typeAnalyzer: (SymbolContext, Type) -> Type,
            variableContext: SymbolContext,
            identifier: Identifier
    ): Identifier {
        return identifier.run {
            val expectedType = variableContext.getVar(name)
                    ?: throw QuartzException("Could not find variable $name")

            Identifier(name, typeAnalyzer(variableContext, expectedType))
        }
    }
}
