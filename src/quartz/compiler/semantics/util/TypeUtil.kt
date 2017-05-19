package quartz.compiler.semantics.util

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.contexts.SymbolContext
import quartz.compiler.semantics.contexts.TypeContext
import quartz.compiler.semantics.types.ConstType
import quartz.compiler.semantics.types.VoidType
import quartz.compiler.semantics.visitors.TypeAnalyzer
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

fun Type?.verifyAs(type: Type?): Type? {
    return when {
        type == null || type == VoidType -> this
        this == null -> type
        this.isEqualTo(type) -> this
        this.isInstance(type) -> type
        type is ConstType && type.type.isInstance(this) -> this.verifyAs(type.type)
        else -> throw QuartzException("Could not destructureAs $this to $type")
    }
}

fun Type.analyze(symbolContext: SymbolContext): TypeContext {
    return TypeAnalyzer(TypeContext(this, symbolContext))
}
