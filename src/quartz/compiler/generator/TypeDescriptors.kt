package quartz.compiler.generator

import quartz.compiler.errors.err
import quartz.compiler.semantics.types.*
import quartz.compiler.tree.util.Function
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

fun Type.description(): String {
    return when (this) {
        is InlineCType -> string
        is NamedType -> string
        is NumberType -> string
        is VoidType -> "void"
        is PointerType -> "ptr_${type.description()}"
        is ConstType -> "const_${type.description()}"
        is FunctionType -> function.description()
        else -> err { "Expected type, found $this" }
    }
}

fun Function.description(): String {
    val args = args ?: emptyList()
    var string = ""
    when {
        args.isEmpty() -> {
            string += returnType.description() + "_supplier"
        }
        else -> {
            args.forEach { string += it.description() + '_' }
            string += "to_"
            string += returnType.description()
        }
    }
    if (vararg)
        string += "_vararg"

    return string
}
