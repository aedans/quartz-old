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

object TypeVisitor {
    inline fun visitConstType(typeVisitor: Visitor<Type>, type: ConstType): ConstType {
        return ConstType(typeVisitor(type.type))
    }

    inline fun visitPointerType(typeVisitor: Visitor<Type>, type: PointerType): PointerType {
        return PointerType(typeVisitor(type.type))
    }

    inline fun visitFunctionType(typeVisitor: Visitor<Type>, type: FunctionType): FunctionType {
        return FunctionType(visitFunctionTypes(typeVisitor, type.function))
    }

    inline fun visitNamedType(typeProvider: (String) -> Type?, type: NamedType): Type {
        return typeProvider(type.string)
                ?: throw QuartzException("Unknown type ${type.string}")
    }

    inline fun visitFunctionTypes(typeVisitor: Visitor<Type>, function: Function): Function {
        return Function(
                function.args?.map { it?.let(typeVisitor) },
                function.returnType?.let(typeVisitor),
                function.vararg
        )
    }
}
