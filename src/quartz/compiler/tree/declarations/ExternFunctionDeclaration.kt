package quartz.compiler.tree.declarations

import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.tree.VariableDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.tree.util.functionString
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

data class ExternFunctionDeclaration(
        override val name: String,
        val args: List<Type>,
        val returnType: Type,
        val vararg: Boolean
) : VariableDeclaration {
    override val type = FunctionType(args, returnType, vararg)

    inline fun visitArgs(typeVisitor: Visitor<Type>): ExternFunctionDeclaration {
        return copy(args = args.map(typeVisitor))
    }

    inline fun visitReturnType(typeVisitor: Visitor<Type>): ExternFunctionDeclaration {
        return copy(returnType = typeVisitor(returnType))
    }

    inline fun visitTypes(typeVisitor: Visitor<Type>): ExternFunctionDeclaration {
        return visitArgs(typeVisitor).visitReturnType(typeVisitor)
    }

    override fun toString(): String {
        return "$name${functionString(args, returnType, vararg)}"
    }
}
