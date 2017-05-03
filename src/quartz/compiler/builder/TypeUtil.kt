package quartz.compiler.builder

import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.*
import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.TypeContext.toType(): Type {
    val type = ltype().toType()
    return if (isConst != null) ConstType(type) else type
}

fun QuartzParser.LtypeContext.toType(): Type {
    return errorScope({ "type $text" }) {
        if (NAME() != null) {
            when (NAME().text) {
                "bool" -> Primitives.bool
                "char" -> Primitives.char
                "short" -> Primitives.short
                "int" -> Primitives.int
                "long" -> Primitives.long
                "uchar" -> Primitives.uchar
                "ushort" -> Primitives.ushort
                "uint" -> Primitives.uint
                "ulong" -> Primitives.ulong
                "float" -> Primitives.float
                "double" -> Primitives.double
                "void" -> Primitives.void
                else -> UnresolvedType(NAME().text)
            }
        } else {
            if (ptr != null) {
                PointerType(ltype().toType())
            } else {
                FunctionType(Function(
                        args.type().map { it.toType() },
                        returnType.toType(),
                        args.vararg != null
                ))
            }
        }
    }
}
