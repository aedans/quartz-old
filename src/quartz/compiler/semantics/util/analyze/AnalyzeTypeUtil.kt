package quartz.compiler.semantics.util.analyze

import quartz.compiler.errors.except
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

inline fun ConstType.visitConstType(typeVisitor: Visitor<Type>): ConstType {
    return ConstType(typeVisitor(type))
}

inline fun PointerType.visitPointerType(typeVisitor: Visitor<Type>): PointerType {
    return PointerType(typeVisitor(type))
}

inline fun FunctionType.visitFunctionType(typeVisitor: Visitor<Type>): FunctionType {
    return FunctionType(function.visitFunctionTypes(typeVisitor))
}

inline fun NamedType.visitNamedType(typeProvider: (String) -> Type?, typeVisitor: Visitor<Type>): Type {
    return typeVisitor(typeProvider(string)
            ?: except { "Unknown type $string" })
}

inline fun Function.visitFunctionTypes(typeVisitor: Visitor<Type>): Function {
    return Function(
            args?.map { it.let(typeVisitor) },
            returnType.let(typeVisitor),
            vararg
    )
}
