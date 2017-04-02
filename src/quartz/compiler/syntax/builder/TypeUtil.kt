package quartz.compiler.syntax.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.util.Function
import quartz.compiler.util.Type
import quartz.compiler.util.types.ArrayType
import quartz.compiler.util.types.FunctionType
import quartz.compiler.util.types.Primitives
import quartz.compiler.util.types.StructType

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.TypeContext.toType(): Type {
    return if (identifier() != null) {
        when (identifier().text) {
            "char" -> Primitives.char
            "short" -> Primitives.short
            "int" -> Primitives.int
            "long" -> Primitives.long
            "float" -> Primitives.float
            "double" -> Primitives.double
            "void" -> Primitives.void
            else -> StructType(identifier().text, mapOf())
        }
    } else {
        if (array != null) {
            ArrayType(type().toType())
        } else {
            FunctionType(Function(args.type().map { it.toType() }, returnType.toType(), args.vararg != null))
        }
    }
}
