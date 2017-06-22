package quartz.compiler.semantics.util.analyze.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.UnaryOperator
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

inline fun UnaryOperator.visitExpression(expressionVisitor: Visitor<Expression>): UnaryOperator {
    return copy(expression = expressionVisitor(expression))
}

inline fun UnaryOperator.analyzeExpression(expressionAnalyzer: (Type, Expression) -> Expression, expectedType: Type): UnaryOperator {
    return visitExpression(expressionAnalyzer.partial(expectedType))
}
