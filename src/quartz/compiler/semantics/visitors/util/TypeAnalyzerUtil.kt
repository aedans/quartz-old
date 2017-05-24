package quartz.compiler.semantics.visitors.util

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.contexts.TypeContext
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

inline fun <reified T : Expression> ExpressionContext.analyzeType(
        typeAnalyzer: Visitor<TypeContext>,
        function: (T) -> Type?,
        clone: (T, Type) -> T
): ExpressionContext {
    val (expression, symbolContext) = this.destructureAs<T>()
    val type = function(expression)
    return type?.let {
        val (newType, newSymbolContext) = typeAnalyzer(TypeContext(it, symbolContext))
        this.copy(
                expression = clone(expression, newType),
                symbolContext = newSymbolContext
        )
    } ?: this
}
