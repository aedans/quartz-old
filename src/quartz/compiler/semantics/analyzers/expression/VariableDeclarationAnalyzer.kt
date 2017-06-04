package quartz.compiler.semantics.analyzers.expression

import quartz.compiler.semantics.util.TypedExpressionAnalyzer
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.expression.VariableDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

object VariableDeclarationAnalyzer {
    inline fun visitVariableType(typeVisitor: Visitor<Type>, variableDeclaration: VariableDeclaration): VariableDeclaration {
        return variableDeclaration.copy(variableType = variableDeclaration.variableType?.let(typeVisitor))
    }

    inline fun visitExpression(expressionVisitor: Visitor<Expression>, variableDeclaration: VariableDeclaration): VariableDeclaration {
        return variableDeclaration.copy(expression = variableDeclaration.expression?.let(expressionVisitor))
    }

    inline fun analyzeExpression(expressionAnalyzer: TypedExpressionAnalyzer, variableDeclaration: VariableDeclaration): VariableDeclaration {
        return visitExpression(expressionAnalyzer.partial(variableDeclaration.variableType), variableDeclaration)
    }

    fun inferVariableTypeFromExpression(variableDeclaration: VariableDeclaration): VariableDeclaration {
        return variableDeclaration.copy(variableType = variableDeclaration.expression?.type)
    }
}
