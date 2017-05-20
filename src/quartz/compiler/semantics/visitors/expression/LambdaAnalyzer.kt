package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.util.visitor
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.function.expression.Lambda
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object LambdaAnalyzer : Visitor<ExpressionContext> by visitor(
        { expressionContext ->
            val (lambda) = expressionContext.destructureAs<Lambda>()

            if (expressionContext.expectedType is FunctionType && lambda.function != expressionContext.expectedType.function) {
                expressionContext.copy(expression = lambda.copy(function = expressionContext.expectedType.function))
            } else {
                expressionContext
            }
        },
        { expressionContext ->
            val (lambda) = expressionContext.destructureAs<Lambda>()

            if (lambda.function.args == null) {
                expressionContext.copy(expression = lambda.copy(function = lambda.function.copy(args = emptyList())))
            } else {
                expressionContext
            }
        },
        { expressionContext ->
            val (lambda) = expressionContext.destructureAs<Lambda>()

            if (lambda.argNames == null) {
                expressionContext.copy(expression = lambda.copy(argNames = lambda.function.args?.mapIndexed { i, _ -> "p$i" }))
            } else {
                expressionContext
            }
        },
        { expressionContext ->
            val (lambda, symbolContext) = expressionContext.destructureAs<Lambda>()

            val name = "__lambda_${symbolContext.programContext.tempIndex}"
            val functionDeclaration = FunctionDeclaration(
                    name,
                    lambda.argNames!!,
                    emptyList(),
                    lambda.type.function,
                    lambda.block
            )
            val identifier = Identifier(name, emptyList(), FunctionType(functionDeclaration.function))

            expressionContext.copy(
                    expression = identifier,
                    symbolContext = symbolContext.copy(programContext = symbolContext.programContext.copy(
                            context = symbolContext.programContext.context + functionDeclaration,
                            tempIndex = symbolContext.programContext.tempIndex + 1
                    ))
            )
        },
        IdentifierAnalyzer::invoke
)
