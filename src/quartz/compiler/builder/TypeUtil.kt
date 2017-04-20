package quartz.compiler.builder

import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.types.PointerType
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.semantics.types.UnresolvedType
import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.TypeContext.toType(): Type {
    return errorScope({ "type $text" }) {
        if (identifier() != null) {
            when (identifier().text) {
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
                else -> UnresolvedType(identifier().text, typeList()?.type()?.map { it.toType() } ?: emptyList())
            }
        } else {
            if (ptr != null) {
                PointerType(type().toType())
            } else {
                FunctionType(Function(args.type().map { it.toType() }, emptyList(), returnType.toType(), args.vararg != null))
            }
        }
    }
}
