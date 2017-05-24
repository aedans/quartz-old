package quartz.compiler.builder

import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.*
import quartz.compiler.tree.util.Function
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.TypeContext.toType(): Type {
    val type = unqualifiedType().toType()
    return when {
        isConst != null -> ConstType(type)
        else -> type
    }
}

fun QuartzParser.UnqualifiedTypeContext.toType(): Type {
    return errorScope({ "variableType $text" }) {
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
                else -> NamedType(NAME().text)
            }
            INLINE_C() != null -> InlineCType(INLINE_C().text.substring(2, INLINE_C().text.length-2))
            functionType() != null -> functionType().toType()
            ptr != null -> PointerType(unqualifiedType().toType())
            else -> throw Exception("Unknown type $text")
        }
    }
}

fun QuartzParser.FunctionTypeContext.toType(): FunctionType {
    return FunctionType(Function(
            args.type().map { it.toType() },
            returnType.toType(),
            args.vararg != null
    ))
}
