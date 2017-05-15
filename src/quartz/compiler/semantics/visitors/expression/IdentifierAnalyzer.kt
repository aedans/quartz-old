package quartz.compiler.semantics.visitors.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.contexts.ExternFunctionDeclarationContext
import quartz.compiler.semantics.contexts.FunctionDeclarationContext
import quartz.compiler.semantics.types.FunctionType
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
            val (identifier, symbolContext) = expressionContext.asExpression<Identifier>()

            if (!symbolContext.programContext.program.functionDeclarations.contains(identifier.name)) {
                symbolContext.programContext.context.functionDeclarations[identifier.name]?.let {
                    val (newFunction, newProgramContext) = FunctionDeclarationAnalyzer(FunctionDeclarationContext(
                            it,
                            symbolContext.programContext.copy(program = symbolContext.programContext.program + it)
                    ))

                    val newType = FunctionType(newFunction.function)
                    expressionContext.copy(
                            expression = Identifier(newFunction.name, newType),
                            symbolContext = symbolContext.copy(
                                    programContext = newProgramContext.copy(program = newProgramContext.program + newFunction)
                            )
                    )
                } ?: expressionContext
            } else expressionContext
        },
        { expressionContext ->
            val (identifier, symbolContext) = expressionContext.asExpression<Identifier>()

            if (!symbolContext.programContext.program.externFunctionDeclarations.contains(identifier.name)) {
                symbolContext.programContext.context.externFunctionDeclarations[identifier.name]?.let {
                    val (newFunction, newProgramContext) = ExternFunctionDeclarationAnalyzer(ExternFunctionDeclarationContext(
                            it,
                            symbolContext.programContext.copy(program = symbolContext.programContext.program + it)
                    ))

                    val newType = FunctionType(newFunction.function)
                    expressionContext.copy(
                            expression = Identifier(newFunction.name, newType),
                            symbolContext = symbolContext.copy(
                                    programContext = newProgramContext.copy(program = newProgramContext.program + newFunction)
                            )
                    )
                } ?: expressionContext
            } else expressionContext
        },
        { expressionContext ->
            val (identifier, symbolContext) = expressionContext.asExpression<Identifier>()
            val newIdentifier = identifier.run {
                val expectedType = symbolContext.getVar(name)
                        ?: throw QuartzException("Could not find variable $name")
                val newType = when {
                    type == null -> expectedType
                    type.isInstance(expectedType) -> type
                    expectedType.isInstance(type) -> expectedType
                    else -> throw QuartzException("Expected $expectedType, found $this ($type)")
                }

                Identifier(name, newType)
            }

            expressionContext.copy(expression = newIdentifier)
        }
)
