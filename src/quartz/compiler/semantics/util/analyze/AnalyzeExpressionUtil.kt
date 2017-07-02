package quartz.compiler.semantics.util.analyze

import quartz.compiler.errors.except
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

fun Expression.verifyType(type: Type?): Expression {
    val thisType = this.type
    return when {
        type == null -> this
        thisType == null -> this
        type.isConvertibleTo(thisType) -> this
        thisType.isConvertibleTo(type) -> this
        else -> except { "Could not cast $this (${this.type}) to $type" }
    }
}

inline fun <reified T : Expression> T.inferTypeFrom(exprGetter: T.() -> Expression?): T {
    return inferTypeAs { exprGetter()?.type }
}

// TODO greatest common type
inline fun <reified T : Expression> T.inferTypeAs(typeGetter: T.() -> Type?): T {
    val type = typeGetter()
    return when (type) {
        null -> this
        else -> this.withType(type) as T
    }
}
