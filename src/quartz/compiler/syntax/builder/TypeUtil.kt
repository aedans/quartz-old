package quartz.compiler.syntax.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.ArrayType
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.types.NamedType
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.util.Function
import quartz.compiler.util.Type

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
            else -> NamedType(identifier().text)
        }
    } else {
        if (array != null) {
            ArrayType(type().toType())
        } else {
            FunctionType(Function(args.type().map { it.toType() }, emptyList(), returnType.toType(), args.vararg != null))
        }
    }
}
