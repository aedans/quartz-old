package quartz.compiler.semantics.analyzer.type

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.types.ConstType
import quartz.compiler.semantics.types.VoidType
import quartz.compiler.util.Type

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
        else -> throw QuartzException("Could not cast $this to $type")
    }
}
