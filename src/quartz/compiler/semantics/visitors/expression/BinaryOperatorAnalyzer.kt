package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.util.ExpressionAnalyzer
import quartz.compiler.semantics.visitors.util.inferType
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.expression.BinaryOperator
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

object BinaryOperatorAnalyzer {
    inline fun visitExpr1(expressionVisitor: Visitor<Expression>, binaryOperator: BinaryOperator): BinaryOperator {
        return binaryOperator.copy(expr1 = expressionVisitor(binaryOperator.expr1))
    }

    inline fun visitExpr2(expressionVisitor: Visitor<Expression>, binaryOperator: BinaryOperator): BinaryOperator {
        return binaryOperator.copy(expr2 = expressionVisitor(binaryOperator.expr2))
    }

    inline fun analyzeExpr1(expressionAnalyzer: ExpressionAnalyzer, binaryOperator: BinaryOperator, expectedType: Type?): BinaryOperator {
        return visitExpr1(expressionAnalyzer.partial(expectedType), binaryOperator)
    }

    inline fun analyzeExpr2(expressionAnalyzer: ExpressionAnalyzer, binaryOperator: BinaryOperator, expectedType: Type?): BinaryOperator {
        return visitExpr2(expressionAnalyzer.partial(expectedType), binaryOperator)
    }

    fun inferTypeFromExpr1(binaryOperator: BinaryOperator): BinaryOperator {
        return binaryOperator.inferType { it.expr1.type }
    }

    fun inferTypeFromExpr2(binaryOperator: BinaryOperator): BinaryOperator {
        return binaryOperator.inferType { it.expr2.type }
    }
}
