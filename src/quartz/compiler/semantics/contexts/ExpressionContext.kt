package quartz.compiler.semantics.contexts

import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Context

/**
 * Created by Aedan Smith.
 */

data class ExpressionContext(
        val expression: Expression,
        val symbolContext: SymbolContext,
        val expectedType: Type?
) : Context<Expression> {
    override val t
        get() = expression

    inline fun <reified T : Expression> destructureAs(): Triple<T, SymbolContext, Type?> {
        return Triple(expression as? T ?:
                throw ClassCastException("Expected ${T::class}, found ${expression::class}"), symbolContext, expectedType)
    }
}
