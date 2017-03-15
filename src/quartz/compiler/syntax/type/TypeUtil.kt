package quartz.compiler.syntax.type

import quartz.compiler.syntax.type.types.Primitives
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun String.toType(): Type {
    return when (this) {
        "char" -> Primitives.char
        "short" -> Primitives.short
        "int" -> Primitives.int
        "long" -> Primitives.long
        "float" -> Primitives.float
        "double" -> Primitives.double
        else -> throw RuntimeException("Unrecognized type $this")
    }
}
