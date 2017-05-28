package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.types.IntType
import quartz.compiler.semantics.util.ExpressionAnalyzer
import quartz.compiler.semantics.visitors.util.inferType
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.expression.BlockExpression
import quartz.compiler.tree.function.expression.IfExpression
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

    inline fun analyzeCondition(expressionAnalyzer: ExpressionAnalyzer, ifExpression: IfExpression): IfExpression {
        // TODO BoolType
        return visitCondition(expressionAnalyzer.partial(IntType), ifExpression)
    }

    inline fun analyzeIfTrue(expressionAnalyzer: ExpressionAnalyzer, ifExpression: IfExpression, expectedType: Type?): IfExpression {
        return visitIfTrue(expressionAnalyzer.partial(expectedType), ifExpression)
    }

    inline fun analyzeIfFalse(expressionAnalyzer: ExpressionAnalyzer, ifExpression: IfExpression, expectedType: Type?): IfExpression {
        return visitIfFalse(expressionAnalyzer.partial(expectedType), ifExpression)
    }

    fun inferTypeFromIfTrue(ifExpression: IfExpression): IfExpression {
        return ifExpression.inferType { it.ifTrue.type }
    }

    fun inferTypeFromIfFalse(ifExpression: IfExpression): IfExpression {
        return ifExpression.inferType { it.ifFalse.type }
    }
}
