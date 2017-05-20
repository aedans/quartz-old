package quartz.compiler.semantics.visitors

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.contexts.ExpressionContext
import quartz.compiler.semantics.contexts.StructDeclarationContext
import quartz.compiler.semantics.contexts.SymbolContext
import quartz.compiler.semantics.contexts.TypeContext
import quartz.compiler.semantics.types.*
import quartz.compiler.semantics.util.analyze
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.util.Function
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object TypeAnalyzer : Visitor<TypeContext> {
    override fun invoke(typeContext: TypeContext): TypeContext {
        val (type, symbolContext) = typeContext
        return when (type) {
            is VoidType -> typeContext
            is NumberType -> typeContext
            is InlineCType -> typeContext
            is ConstType -> this(typeContext.copy(type = type.type)).let { it.copy(type = ConstType(it.type)) }
            is PointerType -> this(typeContext.copy(type = type.type)).let { it.copy(type = PointerType(it.type)) }
            is FunctionType -> analyze(type.function, symbolContext).let { (function, newSymbolContext) ->
                TypeContext(FunctionType(function), newSymbolContext)
            }
            is StructType -> {
                val structDeclaration = symbolContext.programContext.context.structDeclarations[type.string]
                        ?: throw QuartzException("Unknown struct $this")

                val (newStructDeclaration, newSymbolContext) = StructDeclarationAnalyzer(
                        StructDeclarationContext(structDeclaration, symbolContext)
                )

                TypeContext(StructType(newStructDeclaration), newSymbolContext)
            }
            is UnresolvedType -> {
                this(typeContext.copy(type = symbolContext.getType(type.string)
                        ?: throw QuartzException("Unable to resolve type $type")))
            }
            else -> throw QuartzException("Expected type, found $type")
        }
    }

    fun analyze(function: Function, symbolContext: SymbolContext): Pair<Function, SymbolContext> {
        var mutableSymbolContext = symbolContext
        fun Type.visit(): Type = TypeAnalyzer(TypeContext(this, symbolContext)).let { (type, newSymbolContext) ->
            mutableSymbolContext = newSymbolContext
            type
        }
        return Pair(function.copy(
                args = function.args?.map { it?.visit() },
                returnType = function.returnType?.visit()
        ), mutableSymbolContext)
    }

    inline fun <reified T : Expression> analyzerVisitor(
            crossinline function: (T) -> Type?,
            crossinline clone: (T, Type) -> T
    ): Visitor<ExpressionContext> {
        return { expressionContext ->
            val (expression, symbolContext) = expressionContext.destructureAs<T>()
            val type = function(expression)
            type?.let {
                val (newType, newSymbolContext) = type.analyze(symbolContext)
                expressionContext.copy(
                        expression = clone(expression, newType),
                        symbolContext = newSymbolContext
                )
            } ?: expressionContext
        }
    }
}
