package quartz.compiler.semantics.util.analyze.expressions

import quartz.compiler.semantics.types.IntType
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.Block
import quartz.compiler.tree.expression.expressions.IfExpression
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

inline fun IfExpression.visitCondition(expressionVisitor: Visitor<Expression>): IfExpression {
    return copy(condition = expressionVisitor(condition))
}

inline fun IfExpression.visitIfTrue(expressionVisitor: Visitor<Expression>): IfExpression {
    return copy(ifTrue = expressionVisitor(ifTrue) as Block)
}

inline fun IfExpression.visitIfFalse(expressionVisitor: Visitor<Expression>): IfExpression {
    return copy(ifFalse = expressionVisitor(ifFalse) as Block)
}

inline fun IfExpression.analyzeCondition(expressionAnalyzer: (Type, Expression) -> Expression): IfExpression {
    // TODO BoolType
    return visitCondition(expressionAnalyzer.partial(IntType))
}

inline fun IfExpression.analyzeIfTrue(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): IfExpression {
    return visitIfTrue(expressionAnalyzer.partial(expectedType))
}

inline fun IfExpression.analyzeIfFalse(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): IfExpression {
    return visitIfFalse(expressionAnalyzer.partial(expectedType))
}
