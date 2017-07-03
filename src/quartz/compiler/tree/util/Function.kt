package quartz.compiler.tree.util

import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

data class Function(
        val args: List<Type>?,
        val returnType: Type,
        val vararg: Boolean
) {
    inline fun visitArgs(typeVisitor: Visitor<Type>): Function {
        return copy(args = args?.map(typeVisitor))
    }

    inline fun visitReturnType(typeVisitor: Visitor<Type>): Function {
        return copy(returnType = typeVisitor(returnType))
    }

    inline fun visitTypes(typeVisitor: Visitor<Type>): Function {
        return visitArgs(typeVisitor).visitReturnType(typeVisitor)
    }

    override fun toString(): String {
        return "${args?.joinToString(prefix = "(", postfix = ")") ?: "(???)"}${if (vararg) "..." else ""} -> $returnType"
    }
}
