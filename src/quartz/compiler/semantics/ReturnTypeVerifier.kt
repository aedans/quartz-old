package quartz.compiler.semantics

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.tree.function.statement.Block
import quartz.compiler.tree.function.statement.ReturnStatement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun Block.verifyReturnType(returnType: Type?): Type {
    val returnNodes = getStatements().filterIsInstance(ReturnStatement::class.java)
    val returnTypes = (returnNodes.map { it.expression.type } + returnType).filterNotNull()
    return returnTypes.greatestCommonType()
}

private fun List<Type>.greatestCommonType(): Type {
    var type = if (isNotEmpty()) first() else Primitives.void
    forEach {
        when {
            type.isInstance(it) -> type = it
            it.isInstance(type) -> { }
            else -> throw QuartzException("Multiple return types: $this")
        }
    }
    return type
}
