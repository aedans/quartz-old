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
    return errorScope({ "varType $text" }) {
        when {
            NAME() != null -> when (NAME().text) {
                "bool" -> BoolType
                "char" -> CharType
                "short" -> ShortType
                "int" -> IntType
                "long" -> LongType
                "uchar" -> UCharType
                "ushort" -> UShortType
                "uint" -> UIntType
                "ulong" -> ULongType
                "float" -> FloatType
                "double" -> DoubleType
                "void" -> VoidType
                else -> UnresolvedType(NAME().text)
            }
            INLINE_C() != null -> InlineCType(INLINE_C().text.substring(2, INLINE_C().text.length-2))
            ptr != null -> PointerType(ltype().toType())
            else -> FunctionType(Function(
                    args.type().map { it.toType() },
                    returnType.toType(),
                    args.vararg != null
            ))
        }
    }
}
