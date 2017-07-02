package quartz.compiler.semantics.util.analyze.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.ExpressionPair
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

inline fun ExpressionPair.visitExpr1(expressionVisitor: Visitor<Expression>): ExpressionPair {
    return copy(expr1 = expressionVisitor(expr1))
}

inline fun ExpressionPair.visitExpr2(expressionVisitor: Visitor<Expression>): ExpressionPair {
    return copy(expr2 = expressionVisitor(expr2))
}

inline fun ExpressionPair.analyzeExpr1(expressionAnalyzer: (Type?, Expression) -> Expression): ExpressionPair {
    return visitExpr1(expressionAnalyzer.partial(null))
}

inline fun ExpressionPair.analyzeExpr2(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): ExpressionPair {
    return visitExpr2(expressionAnalyzer.partial(expectedType))
}
