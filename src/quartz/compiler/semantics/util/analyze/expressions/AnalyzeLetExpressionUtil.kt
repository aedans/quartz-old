package quartz.compiler.semantics.util.analyze.expressions

import quartz.compiler.errors.except
import quartz.compiler.semantics.tables.SymbolTable
import quartz.compiler.semantics.util.withVar
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.LetExpression
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor
import quartz.compiler.util.partial

/**
 * Created by Aedan Smith.
 */

inline fun LetExpression.visitVariableType(typeVisitor: Visitor<Type>): LetExpression {
    return copy(variableType = variableType?.let(typeVisitor))
}

inline fun LetExpression.visitValue(expressionVisitor: Visitor<Expression>): LetExpression {
    return copy(value = value?.let(expressionVisitor))
}

inline fun LetExpression.visitExpression(expressionVisitor: Visitor<Expression>): LetExpression {
    return copy(expression = expression.let(expressionVisitor))
}

inline fun LetExpression.analyzeValue(expressionAnalyzer: (Type?, Expression) -> Expression): LetExpression {
    return visitValue(expressionAnalyzer.partial(variableType))
}

inline fun LetExpression.analyzeExpression(
        expressionAnalyzer: (SymbolTable, Type?, Expression) -> Expression,
        symbolTable: SymbolTable,
        expectedType: Type?
): LetExpression {
    return visitExpression(expressionAnalyzer.partial(symbolTable.withVar(name, variableType ?:
            except { "Could not infer type for $this" }
    )).partial(expectedType))
}

fun LetExpression.inferVariableTypeFromExpression(): LetExpression {
    return copy(variableType = value?.type ?: variableType)
}
