package quartz.compiler.semantics.contexts

import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class ExpressionContext(
        val expression: Expression,
        val symbolContext: SymbolContext,
        val expectedType: Type?
) {
    inline fun <reified T : Expression> asExpression(): Triple<T, SymbolContext, Type?> {
        return Triple(expression as? T ?:
                throw Exception("Expected ${T::class.simpleName}, found ${expression::class.simpleName}"), symbolContext, expectedType)
    }
}
