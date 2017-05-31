package quartz.compiler.semantics.visitors

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.types.ConstType
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.types.NamedType
import quartz.compiler.semantics.types.PointerType
import quartz.compiler.tree.util.Function
import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

object TypeAnalyzer {
    inline fun analyzeConstType(typeAnalyzer: Visitor<Type>, type: ConstType): ConstType {
        return ConstType(typeAnalyzer(type.type))
    }

    inline fun analyzePointerType(typeAnalyzer: Visitor<Type>, type: PointerType): PointerType {
        return PointerType(typeAnalyzer(type.type))
    }

    inline fun analyzeFunctionType(typeAnalyzer: Visitor<Type>, type: FunctionType): FunctionType {
        return FunctionType(analyzeFunctionTypes(typeAnalyzer, type.function))
    }

    inline fun analyzeNamedType(typeProvider: (String) -> Type?, type: NamedType): Type {
        return typeProvider(type.string)
                ?: throw QuartzException("Unknown type ${type.string}")
    }

    inline fun analyzeFunctionTypes(typeAnalyzer: Visitor<Type>, function: Function): Function {
        return Function(
                function.args?.map { it?.let(typeAnalyzer) },
                function.returnType?.let(typeAnalyzer),
                function.vararg
        )
    }
}

