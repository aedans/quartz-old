package quartz.compiler.semantics.util.analyze.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.BinaryOperator
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

inline fun BinaryOperator.visitExpr1(expressionVisitor: Visitor<Expression>): BinaryOperator {
    return copy(expr1 = expressionVisitor(expr1))
}

inline fun BinaryOperator.visitExpr2(expressionVisitor: Visitor<Expression>): BinaryOperator {
    return copy(expr2 = expressionVisitor(expr2))
}

inline fun BinaryOperator.analyzeExpr1(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): BinaryOperator {
    return visitExpr1(expressionAnalyzer.partial(expectedType))
}

inline fun BinaryOperator.analyzeExpr2(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): BinaryOperator {
    return visitExpr2(expressionAnalyzer.partial(expectedType))
}
