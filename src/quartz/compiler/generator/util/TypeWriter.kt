package quartz.compiler.generator.util

import quartz.compiler.generator.ProgramOutputStream
import quartz.compiler.semantics.types.*
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

fun ProgramOutputStream.type(type: Type?) {
    type!!
    when (type) {
        is PointerType -> {
            type(type.type)
            string("*")
        }
        is FunctionType -> {
            name("__${type.descriptiveString}_t ")
        }
        is ConstType -> {
            name("const")
            type(type.type)
        }
        is NumberType -> {
            name(type.string)
        }
        is VoidType -> {
            name("void")
        }
        is InlineCType -> {
            name(type.string)
        }
        else -> throw Exception("Expected type, found $type")
    }
}
