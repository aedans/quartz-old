package quartz.compiler.generator.visitors.util

import quartz.compiler.util.Type
import quartz.compiler.util.types.QArray

/**
 * Created by Aedan Smith.
 */

fun Type.visit(string: StringBuilder) {
    when (this) {
        is QArray -> {
            type.visit(string)
            string.append('*')
        }
        else -> string.append(this)
    }
}
