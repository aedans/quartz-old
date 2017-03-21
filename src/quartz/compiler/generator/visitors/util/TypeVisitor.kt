package quartz.compiler.generator.visitors.util

import quartz.compiler.util.Type
import quartz.compiler.util.types.ArrayType
import quartz.compiler.util.types.StructType

/**
 * Created by Aedan Smith.
 */

fun Type.visit(string: StringBuilder) {
    when (this) {
        is ArrayType -> {
            type.visit(string)
            string.append('*')
        }
        is StructType -> {
            string.append("struct ")
            string.append(this)
        }
        else -> string.append(this)
    }
}
