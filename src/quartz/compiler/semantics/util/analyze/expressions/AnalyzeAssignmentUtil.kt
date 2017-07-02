package quartz.compiler.semantics.util.analyze.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.Assignment
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.lValueOrError
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

inline fun Assignment.visitLValue(expressionVisitor: Visitor<Expression>): Assignment {
    return copy(lvalue = expressionVisitor(lvalue).lValueOrError())
}

inline fun Assignment.visitExpression(expressionVisitor: Visitor<Expression>): Assignment {
    return copy(expression = expressionVisitor(expression))
}

inline fun Assignment.analyzeLValue(expressionAnalyzer: (Type?, Expression) -> Expression): Assignment {
    return visitLValue(expressionAnalyzer.partial(null))
}

inline fun Assignment.analyzeExpression(expressionAnalyzer: (Type?, Expression) -> Expression, expectedType: Type?): Assignment {
    return visitExpression(expressionAnalyzer.partial(expectedType))
}
