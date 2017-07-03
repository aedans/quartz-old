package quartz.compiler.tree.util

/**
 * Created by Aedan Smith.
 */

fun functionString(args: List<Type>?, returnType: Type, vararg: Boolean): String {
    return "${args?.joinToString(prefix = "(", postfix = ")") ?: "(???)"}${if (vararg) "..." else ""} -> $returnType"
}
