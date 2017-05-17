package quartz.compiler.semantics.visitors

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.util.analyze
import quartz.compiler.semantics.util.verifyAs
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.visitors.expression.*
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.expression.*
import quartz.compiler.tree.misc.InlineC
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object ExpressionAnalyzer : Visitor<ExpressionContext> by visitor(
        { expressionContext ->
            errorScope({ "expression ${expressionContext.expression}" }) {
                when (expressionContext.expression) {
                    is InlineC -> expressionContext
                    is NumberLiteral -> expressionContext
                    is StringLiteral -> expressionContext
                    is Identifier -> IdentifierAnalyzer(expressionContext)
                    is Sizeof -> SizeofAnalyzer(expressionContext)
                    is Cast -> CastAnalyzer(expressionContext)
                    is ReturnExpression -> ReturnAnalyzer(expressionContext)
                    is PrefixUnaryOperator -> PrefixUnaryOperatorAnalyzer(expressionContext)
                    is PostfixUnaryOperator -> PostfixUnaryOperatorAnalyzer(expressionContext)
                    is BinaryOperator -> BinaryOperatorAnalyzer(expressionContext)
                    is Assignment -> AssignmentAnalyzer(expressionContext)
                    is FunctionCall -> FunctionCallAnalyzer(expressionContext)
                    is MemberAccess -> MemberAccessAnalyzer(expressionContext)
                    is IfExpression -> IfExpressionAnalyzer(expressionContext)
                    is WhileExpression -> WhileExpressionAnalyzer(expressionContext)
                    is VariableDeclaration -> VariableDeclarationAnalyzer(expressionContext)
                    is BlockExpression -> BlockExpressionAnalyzer(expressionContext)
                    is Lambda -> LambdaAnalyzer(expressionContext)
                    else -> throw QuartzException("Expected expression, found ${expressionContext.expression}")
                }.let { it.copy(expression = it.expression.verifyAs(expressionContext.expectedType)) }
            }
        }
) {
    inline fun <reified T : Expression> analyzerVisitor(
            crossinline function: (T) -> Expression?,
            crossinline expectedType: (ExpressionContext, T) -> Type?,
            crossinline clone: (T, Expression) -> T
    ): Visitor<ExpressionContext> {
        return { expressionContext ->
            val (expression, symbolContext) = expressionContext.asExpression<T>()
            val sExpression = function(expression)
            sExpression?.let {
                val (newExpression, newScopeContext, newType) =
                        sExpression.analyze(symbolContext, expectedType(expressionContext, expression))
                ExpressionContext(
                        clone(expression, newExpression),
                        newScopeContext,
                        newType
                )
            } ?: expressionContext
        }
    }

    inline fun <reified T : Expression> typeAnalyzerVisitor(
            crossinline function: (T) -> Type?,
            crossinline clone: (T, Type) -> T
    ): Visitor<ExpressionContext> {
        return { expressionContext ->
            val (expression, symbolContext) = expressionContext.asExpression<T>()
            val type = function(expression)
            // TODO replace with highest bounded type
            ExpressionContext(
                    clone(expression, type ?: throw QuartzException("Could not infer type for $expression")),
                    symbolContext,
                    type
            )
        }
    }
}
