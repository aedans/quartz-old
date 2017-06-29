package quartz.compiler.semantics.util.analyze.expressions

import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.VariableDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

inline fun VariableDeclaration.visitVariableType(typeVisitor: Visitor<Type>): VariableDeclaration {
    return copy(variableType = variableType?.let(typeVisitor))
}

inline fun VariableDeclaration.visitExpression(expressionVisitor: Visitor<Expression>): VariableDeclaration {
    return copy(expression = expression?.let(expressionVisitor))
}

inline fun VariableDeclaration.analyzeExpression(expressionAnalyzer: (Type?, Expression) -> Expression): VariableDeclaration {
    return visitExpression(expressionAnalyzer.partial(variableType))
}

fun VariableDeclaration.inferVariableTypeFromExpression(): VariableDeclaration {
    return copy(variableType = expression?.type ?: variableType)
}
