package quartz.compiler.generator.util

import quartz.compiler.generator.ProgramOutputStream
import quartz.compiler.semantics.types.ArrayType
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.types.StructType
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun ProgramOutputStream.type(type: Type) {
    when (type) {
        is ArrayType -> {
            type(type.type)
            string("*")
        }
        is StructType -> {
            name("struct")
            name(type.string)
        }
        is FunctionType -> {
            string(type.descriptiveString)
            string("_t ")
        }
        else -> name(type)
    }
}
