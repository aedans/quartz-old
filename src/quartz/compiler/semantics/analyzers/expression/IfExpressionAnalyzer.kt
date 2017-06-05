package quartz.compiler.semantics.analyzers.expression

import quartz.compiler.semantics.analyzers.util.inferType
import quartz.compiler.semantics.types.IntType
import quartz.compiler.semantics.util.TypedExpressionAnalyzer
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.BlockExpression
import quartz.compiler.tree.expression.expressions.IfExpression
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

object IfExpressionAnalyzer {
    inline fun visitCondition(expressionVisitor: Visitor<Expression>, ifExpression: IfExpression): IfExpression {
        return ifExpression.copy(condition = expressionVisitor(ifExpression.condition))
    }

    inline fun visitIfTrue(expressionVisitor: Visitor<Expression>, ifExpression: IfExpression): IfExpression {
        return ifExpression.copy(ifTrue = expressionVisitor(ifExpression.ifTrue) as BlockExpression)
    }

    inline fun visitIfFalse(expressionVisitor: Visitor<Expression>, ifExpression: IfExpression): IfExpression {
        return ifExpression.copy(ifFalse = expressionVisitor(ifExpression.ifFalse) as BlockExpression)
    }

    inline fun analyzeCondition(expressionAnalyzer: TypedExpressionAnalyzer, ifExpression: IfExpression): IfExpression {
        // TODO BoolType
        return visitCondition(expressionAnalyzer.partial(IntType), ifExpression)
    }

    inline fun analyzeIfTrue(expressionAnalyzer: TypedExpressionAnalyzer, ifExpression: IfExpression, expectedType: Type?): IfExpression {
        return visitIfTrue(expressionAnalyzer.partial(expectedType), ifExpression)
    }

    inline fun analyzeIfFalse(expressionAnalyzer: TypedExpressionAnalyzer, ifExpression: IfExpression, expectedType: Type?): IfExpression {
        return visitIfFalse(expressionAnalyzer.partial(expectedType), ifExpression)
    }

    fun inferTypeFromIfTrue(ifExpression: IfExpression): IfExpression {
        return ifExpression.inferType { it.ifTrue.type }
    }

    fun inferTypeFromIfFalse(ifExpression: IfExpression): IfExpression {
        return ifExpression.inferType { it.ifFalse.type }
    }
}
