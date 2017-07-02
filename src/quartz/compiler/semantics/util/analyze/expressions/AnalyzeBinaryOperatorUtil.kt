package quartz.compiler.semantics.util.analyze.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.BinaryOperation
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

inline fun BinaryOperation.visitExpr1(expressionVisitor: Visitor<Expression>): BinaryOperation {
    return copy(expr1 = expressionVisitor(expr1))
}

inline fun BinaryOperation.visitExpr2(expressionVisitor: Visitor<Expression>): BinaryOperation {
    return copy(expr2 = expressionVisitor(expr2))
}

inline fun BinaryOperation.analyzeExpr1(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): BinaryOperation {
    return visitExpr1(expressionAnalyzer.partial(expectedType))
}

inline fun BinaryOperation.analyzeExpr2(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): BinaryOperation {
    return visitExpr2(expressionAnalyzer.partial(expectedType))
}
