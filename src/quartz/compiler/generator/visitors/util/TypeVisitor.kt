package quartz.compiler.generator.visitors.util

import quartz.compiler.generator.Visitor
import quartz.compiler.util.Type
import quartz.compiler.util.types.QArray

/**
 * Created by Aedan Smith.
 */

val typeVisitor: Visitor<Type> = { type, string, _ ->
    visit(type, string)
}

private fun visit(type: Type, string: StringBuilder) {
    when (type) {
        is QArray -> {
            visit(type.type, string)
            string.append('*')
        }
        else -> string.append(type)
    }
}
