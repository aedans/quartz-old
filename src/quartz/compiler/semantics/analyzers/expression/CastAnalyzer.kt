package quartz.compiler.semantics.analyzers.expression

import quartz.compiler.semantics.util.TypedExpressionAnalyzer
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.Cast
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

object CastAnalyzer {
    inline fun visitType(typeVisitor: Visitor<Type>, cast: Cast): Cast {
        return cast.copy(type = typeVisitor(cast.type))
    }

    inline fun visitExpression(expressionVisitor: Visitor<Expression>, cast: Cast): Cast {
        return cast.copy(expression = expressionVisitor(cast.expression))
    }

    inline fun analyzeExpression(expressionAnalyzer: TypedExpressionAnalyzer, cast: Cast, expectedType: Type?): Cast {
        return visitExpression(expressionAnalyzer.partial(expectedType), cast)
    }
}
