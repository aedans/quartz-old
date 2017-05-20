package quartz.compiler.semantics.visitors.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.contexts.ExternFunctionDeclarationContext
import quartz.compiler.semantics.contexts.FunctionDeclarationContext
import quartz.compiler.semantics.types.type
import quartz.compiler.semantics.util.visitor
import quartz.compiler.semantics.visitors.ExternFunctionDeclarationAnalyzer
import quartz.compiler.semantics.visitors.FunctionDeclarationAnalyzer
import quartz.compiler.tree.function.expression.Identifier
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object IdentifierAnalyzer : Visitor<ExpressionContext> by visitor(
        { expressionContext ->
            val (identifier, symbolContext) = expressionContext.destructureAs<Identifier>()

            if (symbolContext.getFunctionDeclaration(identifier.name) == null) {
                symbolContext.programContext.context.functionDeclarations[identifier.name]?.let {
                    val (newFunction, newSymbolContext) = FunctionDeclarationAnalyzer(FunctionDeclarationContext(
                            it,
                            symbolContext,
                            identifier.genericArguments
                    ))

                    expressionContext.copy(
                            expression = Identifier(newFunction.name, emptyList(), newFunction.type()),
                            symbolContext = newSymbolContext
                    )
                } ?: expressionContext
            } else expressionContext
        },
        { expressionContext ->
            val (identifier, symbolContext) = expressionContext.destructureAs<Identifier>()

            if (!symbolContext.programContext.program.externFunctionDeclarations.contains(identifier.name)) {
                symbolContext.programContext.context.externFunctionDeclarations[identifier.name]?.let {
                    val (newFunction, newSymbolContext) = ExternFunctionDeclarationAnalyzer(ExternFunctionDeclarationContext(
                            it, symbolContext
                    ))

                    expressionContext.copy(
                            expression = Identifier(newFunction.name, emptyList(), newFunction.type()),
                            symbolContext = newSymbolContext
                    )
                } ?: expressionContext
            } else {
                expressionContext
            }
        },
        { expressionContext ->
            val (identifier, symbolContext) = expressionContext.destructureAs<Identifier>()
            val newIdentifier = identifier.run {
                val expectedType = symbolContext.getVar(name)
                        ?: throw QuartzException("Could not find variable $name")
                val newType = when {
                    type == null -> expectedType
                    type.isInstance(expectedType) -> type
                    expectedType.isInstance(type) -> expectedType
                    else -> throw QuartzException("Expected $expectedType, found $this ($type)")
                }

                Identifier(name, emptyList(), newType)
            }

            expressionContext.copy(expression = newIdentifier)
        }
)
