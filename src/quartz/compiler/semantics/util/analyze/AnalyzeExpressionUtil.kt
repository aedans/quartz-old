package quartz.compiler.semantics.util.analyze

import quartz.compiler.errors.QuartzException
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

fun Expression.verifyType(type: Type?): Expression {
    return when {
        type == null -> this
        this.type == null -> this
        type.isConvertibleTo(this.type!!) -> this
        this.type!!.isConvertibleTo(type) -> this
        else -> throw QuartzException("Could not cast $this (${this.type}) to $type")
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
