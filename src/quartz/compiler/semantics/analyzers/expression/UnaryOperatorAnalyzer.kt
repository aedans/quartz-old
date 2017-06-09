package quartz.compiler.semantics.analyzers.expression

import quartz.compiler.semantics.analyzers.util.inferType
import quartz.compiler.semantics.util.ExpressionAnalyzer
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.UnaryOperator
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

object UnaryOperatorAnalyzer {
    inline fun visitExpression(expressionVisitor: Visitor<Expression>, unaryOperator: UnaryOperator): UnaryOperator {
        return unaryOperator.copy(expression = expressionVisitor(unaryOperator.expression))
    }

    inline fun analyzeExpression(expressionAnalyzer: ExpressionAnalyzer, unaryOperator: UnaryOperator, expectedType: Type?): UnaryOperator {
        return visitExpression(expressionAnalyzer.partial(expectedType), unaryOperator)
    }

    fun inferTypeFromExpression(unaryOperator: UnaryOperator): UnaryOperator {
        return unaryOperator.inferType { it.expression.type }
    }
}