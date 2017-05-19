package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.visitors.ExpressionAnalyzer
import quartz.compiler.semantics.visitors.TypeAnalyzer
import quartz.compiler.tree.function.expression.VariableDeclaration
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object VariableDeclarationAnalyzer : Visitor<ExpressionContext> by visitor(
        TypeAnalyzer.analyzerVisitor<VariableDeclaration>({ it.varType }) { e, varType -> e.copy(varType = varType) },
        ExpressionAnalyzer.analyzerVisitor<VariableDeclaration>({ it.expression }, { _, e -> e.varType }) {
            e, expression -> e.copy(expression = expression, varType = expression.type) },
        ExpressionAnalyzer.typeAnalyzerVisitor<VariableDeclaration>({ it.varType }) {
            e, type -> e.copy(expression = e.expression?.withType(type)) },
        { expressionContext ->
            val (variableDeclaration, symbolContext) = expressionContext.destructureAs<VariableDeclaration>()
            expressionContext.copy(
                    symbolContext = symbolContext.addVar(variableDeclaration.name, variableDeclaration.varType!!)
            )
        }
)
