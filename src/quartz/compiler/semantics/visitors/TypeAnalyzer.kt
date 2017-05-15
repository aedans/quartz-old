package quartz.compiler.semantics.visitors

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.contexts.ProgramContext
import quartz.compiler.semantics.contexts.StructDeclarationContext
import quartz.compiler.semantics.contexts.TypeContext
import quartz.compiler.semantics.types.*
import quartz.compiler.semantics.util.analyze
import quartz.compiler.tree.function.Expression
import quartz.compiler.util.Function
import quartz.compiler.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object TypeAnalyzer : Visitor<TypeContext> {
    override fun invoke(typeContext: TypeContext): TypeContext {
        val (type, programContext) = typeContext
        return when (type) {
            is VoidType -> typeContext
            is NumberType -> typeContext
            is ConstType -> this(typeContext.copy(type = type.type)).let { it.copy(type = ConstType(it.type)) }
            is PointerType -> this(typeContext.copy(type = type.type)).let { it.copy(type = PointerType(it.type)) }
            is FunctionType -> analyze(type.function, programContext).let { (function, programContext) ->
                TypeContext(FunctionType(function), programContext)
            }
            is StructType -> {
                val structDeclaration = programContext.context.structDeclarations[type.string]
                        ?: throw QuartzException("Unknown struct $this")

                val (newStructDeclaration, newProgramContext) = StructDeclarationAnalyzer(
                        StructDeclarationContext(structDeclaration, programContext)
                )

                TypeContext(StructType(newStructDeclaration), newProgramContext)
            }
            is UnresolvedType -> {
                this(typeContext.copy(type = typeContext.getType(type.string)
                        ?: throw QuartzException("Unable to resolve type $type")))
            }
            else -> throw QuartzException("Expected type, found $this")
        }
    }

    fun analyze(function: Function, programContext: ProgramContext): Pair<Function, ProgramContext> {
        var mutableProgramContext = programContext
        fun Type.visit(): Type = TypeAnalyzer(TypeContext(this, mutableProgramContext)).let {
            val (type, newProgramContext) = it
            mutableProgramContext = newProgramContext
            type
        }
        return Pair(function.copy(
                args = function.args?.map { it?.visit() },
                returnType = function.returnType?.visit()
        ), mutableProgramContext)
    }

    inline fun <reified T : Expression> analyzerVisitor(
            crossinline function: (T) -> Type?,
            crossinline clone: (T, Type) -> T
    ): Visitor<ExpressionContext> {
        return { expressionContext ->
            val (expression, symbolContext) = expressionContext.asExpression<T>()
            val type = function(expression)
            type?.let {
                val (newType, newProgramContext) = type.analyze(symbolContext)
                expressionContext.copy(
                        expression = clone(expression, newType),
                        symbolContext = symbolContext.copy(newProgramContext)
                )
            } ?: expressionContext
        }
    }
}
