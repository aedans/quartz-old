package quartz.compiler.semantics.contexts

import quartz.compiler.tree.util.Type
import quartz.compiler.util.Context

/**
 * Created by Aedan Smith.
 */

data class TypeContext(
        val type: Type,
        val symbolContext: SymbolContext
) : Context<Type> {
    override val t
        get() = type
}
