package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.contexts.TypeContext
import quartz.compiler.semantics.visitors.util.analyzeType
import quartz.compiler.tree.function.expression.Sizeof
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object SizeofAnalyzer {
    inline fun analyzeSizeType(
            crossinline typeAnalyzer: Visitor<TypeContext>,
            context: ExpressionContext
    ): ExpressionContext {
        return context.analyzeType<Sizeof>(typeAnalyzer, { it.sizeType }, { e, type -> e.copy(sizeType = type) })
    }
}
