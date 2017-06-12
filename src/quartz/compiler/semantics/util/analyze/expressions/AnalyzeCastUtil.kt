package quartz.compiler.semantics.util.analyze.expressions

import quartz.compiler.semantics.util.ExpressionAnalyzer
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.Cast
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

inline fun Cast.visitType(typeVisitor: Visitor<Type>): Cast {
    return copy(type = typeVisitor(type))
}

inline fun Cast.visitExpression(expressionVisitor: Visitor<Expression>): Cast {
    return copy(expression = expressionVisitor(expression))
}

inline fun Cast.analyzeExpression(expressionAnalyzer: ExpressionAnalyzer, expectedType: Type): Cast {
    return visitExpression(expressionAnalyzer.partial(expectedType))
}
