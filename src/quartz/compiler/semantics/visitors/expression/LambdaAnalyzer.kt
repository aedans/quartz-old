package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.function.expression.Lambda

/**
 * Created by Aedan Smith.
 */

object LambdaAnalyzer {
    fun inferFunctionType(context: ExpressionContext): ExpressionContext {
        val (lambda) = context.destructureAs<Lambda>()

        return if (context.expectedType is FunctionType && lambda.function != context.expectedType.function) {
            context.copy(expression = lambda.copy(function = context.expectedType.function))
        } else {
            context
        }
    }

    fun inferFunctionArgs(context: ExpressionContext): ExpressionContext {
        val (lambda) = context.destructureAs<Lambda>()

        return if (lambda.function.args == null) {
            context.copy(expression = lambda.copy(function = lambda.function.copy(args = emptyList())))
        } else {
            context
        }
    }

    fun inferArgumentNames(context: ExpressionContext): ExpressionContext {
        val (lambda) = context.destructureAs<Lambda>()

        return if (lambda.argNames == null) {
            context.copy(expression = lambda.copy(argNames = lambda.function.args?.mapIndexed { i, _ -> "p$i" }))
        } else {
            context
        }
    }

    fun uninline(context: ExpressionContext): ExpressionContext {
        val (lambda, symbolContext) = context.destructureAs<Lambda>()

        val name = "__lambda_${symbolContext.programContext.tempIndex}"
        val functionDeclaration = FunctionDeclaration(
                name,
                lambda.argNames!!,
                emptyList(),
                lambda.type.function,
                lambda.block
        )
        val identifier = Identifier(name, emptyList(), FunctionType(functionDeclaration.function))

        return context.copy(
                expression = identifier,
                symbolContext = symbolContext.copy(programContext = symbolContext.programContext.copy(
                        context = symbolContext.programContext.context + functionDeclaration,
                        tempIndex = symbolContext.programContext.tempIndex + 1
                ))
        )
    }
}
