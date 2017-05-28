package quartz.compiler.semantics.visitors.expression

import quartz.compiler.semantics.consumers.FunctionDeclarationConsumer
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.function.expression.Lambda
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

object LambdaAnalyzer {
    fun inferFunctionType(lambda: Lambda, expectedType: Type?): Lambda {
        return if (expectedType is FunctionType && lambda.function != expectedType.function) {
            lambda.copy(function = expectedType.function)
        } else {
            lambda
        }
    }

    fun inferFunctionArgs(lambda: Lambda): Lambda {
        return if (lambda.function.args == null) {
            lambda.copy(function = lambda.function.copy(args = emptyList()))
        } else {
            lambda
        }
    }

    fun inferArgumentNames(lambda: Lambda): Lambda {
        return if (lambda.argNames == null) {
            lambda.copy(argNames = lambda.function.args?.mapIndexed { i, _ -> "p$i" })
        } else {
            lambda
        }
    }

    fun toIdentifier(nameTester: (String) -> Boolean, lambda: Lambda): Pair<Identifier, FunctionDeclaration> {
        val name = lambdaName(nameTester, lambda)
        val functionDeclaration = FunctionDeclaration(
                name,
                lambda.argNames!!,
                emptyList(),
                lambda.type.function,
                lambda.block
        )
        return Identifier(name, emptyList(), FunctionType(functionDeclaration.function)) to functionDeclaration
    }

    private tailrec fun lambdaName(nameTester: (String) -> Boolean, lambda: Lambda, int: Int = lambda.hashCode()): String {
        val name = "__lambda_${Math.abs(int)}"
        return if (!nameTester(name)) name else lambdaName(nameTester, lambda, int + 1)
    }

    fun uninline(nameTester: (String) -> Boolean, lambda: Lambda, consumer: FunctionDeclarationConsumer): Identifier {
        val (identifier, functionDeclaration) = toIdentifier(nameTester, lambda)
        consumer.eat(functionDeclaration)
        return identifier
    }
}
