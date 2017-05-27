package quartz.compiler.semantics.contexts

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class TypeContext(
        val type: Type,
        val symbolContext: SymbolContext
)
