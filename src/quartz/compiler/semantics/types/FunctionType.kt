package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Type
import quartz.compiler.tree.util.functionString
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

data class FunctionType(
        val args: List<Type>,
        val returnType: Type,
        val vararg: Boolean
) : Type {
    override fun isConvertibleTo(type: Type): Boolean {
        return type is FunctionType
                && type.vararg == vararg
                && type.returnType.isConvertibleTo(returnType)
                && type.args.size == args.size
                && type.args.zip(args).all { it.first.isConvertibleTo(it.second) }
    }

    inline fun visitArgs(typeVisitor: Visitor<Type>): FunctionType {
        return copy(args = args.map(typeVisitor))
    }

    inline fun visitReturnType(typeVisitor: Visitor<Type>): FunctionType {
        return copy(returnType = typeVisitor(returnType))
    }

    inline fun visitTypes(typeVisitor: Visitor<Type>): FunctionType {
        return visitArgs(typeVisitor).visitReturnType(typeVisitor)
    }

    override fun toString(): String {
        return functionString(args, returnType, vararg)
    }
}
