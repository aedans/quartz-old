package quartz.compiler.syntax.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.util.Type
import quartz.compiler.util.types.QArray
import types.Primitives

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.VarTypeContext.toType(): Type {
    return if (typeName != null) {
        when (typeName.IDENTIFIER().text) {
            "char" -> Primitives.char
            "short" -> Primitives.short
            "int" -> Primitives.int
            "long" -> Primitives.long
            "float" -> Primitives.float
            "double" -> Primitives.double
            else -> TODO("Structs")
        }
    } else {
        QArray(varType().toType())
    }
}
