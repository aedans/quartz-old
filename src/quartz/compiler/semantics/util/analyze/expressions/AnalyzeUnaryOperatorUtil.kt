package quartz.compiler.semantics.util.analyze.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.UnaryOperation
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

inline fun UnaryOperation.visitExpression(expressionVisitor: Visitor<Expression>): UnaryOperation {
    return copy(expression = expressionVisitor(expression))
}

inline fun UnaryOperation.analyzeExpression(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): UnaryOperation {
    return visitExpression(expressionAnalyzer.partial(expectedType))
}
