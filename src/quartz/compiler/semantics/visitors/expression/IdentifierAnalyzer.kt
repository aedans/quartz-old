package quartz.compiler.semantics.visitors.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.contexts.ExternFunctionDeclarationContext
import quartz.compiler.semantics.contexts.FunctionDeclarationContext
import quartz.compiler.semantics.types.type
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object IdentifierAnalyzer {
    inline fun analyzeFunctionDeclaration(
            functionDeclarationAnalyzer: Visitor<FunctionDeclarationContext>,
            context: ExpressionContext
    ): ExpressionContext {
        val (identifier, symbolContext) = context.destructureAs<Identifier>()

        return if (symbolContext.getFunctionDeclaration(identifier.name) == null) {
            symbolContext.programContext.context.functionDeclarations[identifier.name]?.let {
                val (newFunction, newSymbolContext) = functionDeclarationAnalyzer(FunctionDeclarationContext(
                        it,
                        symbolContext,
                        identifier.genericArguments
                ))

                context.copy(
                        expression = Identifier(newFunction.name, emptyList(), newFunction.type()),
                        symbolContext = newSymbolContext
                )
            } ?: context
        } else {
            context
        }
    }

    inline fun analyzeExternFunctionDeclaration(
            externFunctionDeclarationVisitor: Visitor<ExternFunctionDeclarationContext>,
            context: ExpressionContext
    ): ExpressionContext {
        val (identifier, symbolContext) = context.destructureAs<Identifier>()

        return if (!symbolContext.programContext.program.externFunctionDeclarations.contains(identifier.name)) {
            symbolContext.programContext.context.externFunctionDeclarations[identifier.name]?.let {
                val (newFunction, newSymbolContext) = externFunctionDeclarationVisitor(ExternFunctionDeclarationContext(
                        it, symbolContext
                ))

                context.copy(
                        expression = Identifier(newFunction.name, emptyList(), newFunction.type()),
                        symbolContext = newSymbolContext
                )
            } ?: context
        } else {
            context
        }
    }

    fun analyzeType(context: ExpressionContext): ExpressionContext {
        val (identifier, symbolContext) = context.destructureAs<Identifier>()
        val newIdentifier = identifier.run {
            val expectedType = symbolContext.getVar(name)
                    ?: throw QuartzException("Could not find variable $name")

            Identifier(name, emptyList(), expectedType)
        }

        return context.copy(expression = newIdentifier)
    }
}
