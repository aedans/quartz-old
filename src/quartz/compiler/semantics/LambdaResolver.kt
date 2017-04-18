package quartz.compiler.semantics

import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.tree.function.expression.Lambda

/**
 * Created by Aedan Smith.
 */

fun Program.resolveLambdas(): Program {
    val lambdas = mutableListOf<FunctionDeclaration>()
    val nameSupplier = (0..Integer.MAX_VALUE).iterator()
    val newNode = mapFunctionDeclarations { it.resolveLambdas(lambdas, nameSupplier) }
    return Program(
            newNode.functionDeclarations + lambdas.map { it.name to it }.toMap(),
            newNode.externFunctionDeclarations,
            newNode.structDeclarations,
            newNode.typealiasDeclarationDeclarations,
            newNode.inlineCNodes
    )
}

fun FunctionDeclaration.resolveLambdas(lambdas: MutableList<FunctionDeclaration>, nameSupplier: Iterator<Int>): FunctionDeclaration {
    return this.mapExpressions {
        when (it) {
            is Lambda -> it.resolve(lambdas, nameSupplier)
            else -> it
        }
    }
}

private fun Lambda.resolve(lambdas: MutableList<FunctionDeclaration>, nameSupplier: Iterator<Int>): Identifier {
    val name = "__lambda_${nameSupplier.next()}"
    lambdas.add(FunctionDeclaration(
            name,
            argNames,
            type.function,
            statements
    ).resolveLambdas(lambdas, nameSupplier))
    return Identifier(name, type)
}
