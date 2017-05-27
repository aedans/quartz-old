package quartz.compiler.semantics.visitors

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.contexts.SymbolContext
import quartz.compiler.semantics.contexts.TypeContext
import quartz.compiler.semantics.types.ConstType
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.types.PointerType
import quartz.compiler.tree.util.Function
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object TypeAnalyzer {
    inline fun analyzeConstType(typeAnalyzer: Visitor<TypeContext>, context: TypeContext): TypeContext {
        context.type as ConstType
        return typeAnalyzer(context.copy(type = context.type.type)).let { it.copy(type = ConstType(it.type)) }
    }

    inline fun analyzePointerType(typeAnalyzer: Visitor<TypeContext>, context: TypeContext): TypeContext {
        context.type as PointerType
        return typeAnalyzer(context.copy(type = context.type.type)).let { it.copy(type = PointerType(it.type)) }
    }

    inline fun analyzeFunctionType(
            crossinline typeAnalyzer: Visitor<TypeContext>,
            context: TypeContext
    ): TypeContext {
        context.type as FunctionType
        return analyze(typeAnalyzer, context.type.function, context.symbolContext)
                .let { (function, newSymbolContext) ->
                    TypeContext(FunctionType(function), newSymbolContext)
                }
    }

    inline fun analyzeNamedType(typeAnalyzer: Visitor<TypeContext>, context: TypeContext): TypeContext {
        return typeAnalyzer(context.copy(type = context.symbolContext.getType(context.type.string)
                ?: throw QuartzException("Unable to resolve type ${context.type}")))
    }

    inline fun analyze(
            crossinline typeAnalyzer: Visitor<TypeContext>,
            function: Function, symbolContext: SymbolContext
    ): Pair<Function, SymbolContext> {
        var mutableSymbolContext = symbolContext
        val visit = { type: Type -> typeAnalyzer(TypeContext(type, symbolContext)).let { (type, newSymbolContext) ->
            mutableSymbolContext = newSymbolContext
            type
        } }
        return Pair(function.copy(
                args = function.args?.map { it?.let(visit) },
                returnType = function.returnType?.let(visit)
        ), mutableSymbolContext)
    }
}

