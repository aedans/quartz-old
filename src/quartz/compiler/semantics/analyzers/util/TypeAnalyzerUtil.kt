package quartz.compiler.semantics.analyzers.util

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

// TODO greatest common type
inline fun <reified T : Expression> T.inferType(typeGetter: (T) -> Type?): T {
    val type = typeGetter(this)
    return when (type) {
        null -> this
        else -> this.withType(type) as T
    }
}
