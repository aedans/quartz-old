package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.contexts.TypeContext
import quartz.compiler.semantics.visitors.util.analyzeExpression
import quartz.compiler.semantics.visitors.util.analyzeType
import quartz.compiler.tree.function.expression.VariableDeclaration
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object VariableDeclarationAnalyzer {
    inline fun analyzeVariableType(
            crossinline typeAnalyzer: Visitor<TypeContext>,
            context: ExpressionContext
    ): ExpressionContext {
        return context.analyzeType<VariableDeclaration>(
                typeAnalyzer,
                { it.variableType },
                { e, variableType -> e.copy(variableType = variableType) }
        )
    }

    inline fun analyzeExpression(
            crossinline expressionAnalyzer: Visitor<ExpressionContext>,
            context: ExpressionContext
    ): ExpressionContext {
        return context.analyzeExpression<VariableDeclaration>(
                expressionAnalyzer,
                { it.expression },
                { _, e -> e.variableType },
                { e, expression -> e.copy(expression = expression, variableType = expression.type) }
        )
    }

//    fun inferExpressionTypeFromType(context: ExpressionContext): ExpressionContext {
//        TODO
//    }

    fun addToSymbolTable(context: ExpressionContext): ExpressionContext {
        val (variableDeclaration, symbolContext) = context.destructureAs<VariableDeclaration>()
        return context.copy(
                symbolContext = symbolContext.addVar(variableDeclaration.name, variableDeclaration.variableType!!)
        )
    }
}
