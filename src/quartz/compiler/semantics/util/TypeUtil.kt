package quartz.compiler.semantics.util

import quartz.compiler.semantics.contexts.SymbolContext
import quartz.compiler.semantics.contexts.TypeContext
import quartz.compiler.semantics.visitors.TypeAnalyzer
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

fun Type.analyze(symbolContext: SymbolContext): TypeContext {
    return TypeAnalyzer(TypeContext(this, symbolContext))
}
