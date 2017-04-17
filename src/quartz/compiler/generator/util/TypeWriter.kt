package quartz.compiler.generator.util

import quartz.compiler.generator.ProgramOutputStream
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.types.PointerType
import quartz.compiler.semantics.types.StructType
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun ProgramOutputStream.type(type: Type) {
    when (type) {
        is PointerType -> {
            type(type.type)
            string("*")
        }
        is StructType -> {
            name("struct")
            name(type.string)
        }
        is FunctionType -> {
            name(type.descriptiveString)
            string("_t ")
        }
        else -> name(type)
    }
}
